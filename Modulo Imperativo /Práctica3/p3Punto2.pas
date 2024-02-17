{2. Escribir un programa que:
a. Implemente un módulo que lea información de ventas de un comercio. De cada venta se lee
código de producto, fecha y cantidad de unidades vendidas. La lectura finaliza con el código de
producto 0. Un producto puede estar en más de una venta. Se pide:}

program puntoDos;
type
  srDias=1..31;
  srMes=1..12;
  srAnio=1950..2023;
  regFecha = record
    dia:srDias;
    mes:srMes;
    anio:srAnio;
  end;
  ventas = record
    cod:integer;
    fecha:regFecha;
    unid:integer;
  end;
  arbol = ^nodo;
  nodo = record
    dato:ventas;
    hI:arbol;
    hD:arbol;
  end;
  ventaB = record
    cod:integer;
    uniTot:integer;
  end;
  arbolB = ^nodoB;
  nodoB = record
    dato:ventaB;
    hI:arbolB;
    hD:arbolB;
  end;
  
{Procedimiento para leer una fecha}
procedure leerFecha(var f:regFecha);
begin
  read(f.dia);
  read(f.mes);
  read(f.anio);
end;

{Procedimiento para leer una venta}
procedure leerVenta (var v:ventas);
begin
  read(v.cod);
  if(v.cod<>0)then begin
    leerFecha(v.fecha);
    read(v.unid);
  end;
end;

{i. Generar y retornar un árbol binario de búsqueda de ventas ordenado por código de
producto.}  
{Cargo el arbol A}
procedure agregar(var a:arbol;aux:ventas);
begin
  if (a=nil) then begin
    new(a);
    a^.dato:=aux;
    a^.hI:=nil;
    a^.hD:=nil;
  end
  else if (aux.cod<=a^.dato.cod) then
    agregar(a^.hI,aux)
  else
    agregar(a^.hD,aux);
end;

procedure crearArbolA(var a:arbol);
var 
  aux:ventas;
begin
  leerVenta(aux);
  if (aux.cod<>0) then begin
    agregar(a,aux);
    crearArbolA(a);
  end;
end;
{-----}


{ii. Generar y retornar otro árbol binario de búsqueda de productos vendidos ordenado por
código de producto. Cada nodo del árbol debe contener el código de producto y la
cantidad total de unidades vendida.}
{Cargo el arbol B}
procedure agregarB(var aB:arbolB;a:arbol);
begin
  if (aB=nil) then begin
    new(aB);
    aB^.dato.cod:=a^.dato.cod;
    aB^.dato.uniTot:=a^.dato.unid;
    aB^.hI:=nil;
    aB^.hD:=nil;
  end
  else if (aB^.dato.cod<a^.dato.cod) then
    agregarB(aB^.hI,a)
  else if (aB^.dato.cod>a^.dato.cod) then
    agregarB(aB^.hD,a)
  else
    aB^.dato.uniTot:=aB^.dato.uniTot+a^.dato.unid;
end;

procedure crearArbolB(a:arbol;var aB:arbolB);
begin
  if (a<>nil) then begin
    crearArbolB(a^.hI,aB);
    agregarB(aB,a);
    crearArbolB(a^.hI,aB);
  end;
end;
{-----}

{procedimiento que crea el arbol a, y luego a partir de este arbol crea el arbol b
* y devuelve ambos arboles al programa principal}
{Nota: El módulo debe retornar los dos árboles.}
procedure crearArbolesAyB(var a1:arbol; var a2:arbolB);
begin 
  crearArbolA(a1);
  crearArbolB(a1,a2);
end;

{b. Implemente un módulo que reciba el árbol generado en i. y un código de producto y retorne
la cantidad total de unidades vendidas de ese producto.}
function cantidadTotal(a:arbol;cod:integer):integer;
begin
  if (a=nil) then
    cantidadTotal:=0
  else if (cod>a^.dato.cod) then
    cantidadTotal:=cantidadTotal(a^.hI,cod)
  else if (cod<a^.dato.cod) then
    cantidadTotal:=cantidadTotal(a^.hD,cod)
  else
    cantidadTotal:=a^.dato.unid+cantidadTotal(a^.hI,cod)
end;
{c. Implemente un módulo que reciba el árbol generado en ii. y un código de producto y retorne
la cantidad total de unidades vendidas de ese producto.}
function cantidadTotalArbolB(a:arbolB;cod:integer):integer;
begin
  if(a=nil)then
    cantidadTotalArbolB:=0
  else if (cod>a^.dato.cod) then
    cantidadTotalArbolB:=cantidadTotalArbolB(a^.hI,cod)
  else if (cod<a^.dato.cod) then
    cantidadTotalArbolB:=cantidadTotalArbolB(a^.hD,cod)
  else
    cantidadTotalArbolB:=a^.dato.uniTot;
end;

{PROGRAMA PRINCIPAL}
var
  arbA:arbol;
  arbB:arbolB;
  cod:integer;
begin
  arbA:=nil;
  arbB:=nil;
  crearArbolesAyB(arbA,arbB);
  read(cod);
  writeln ('Cantidad de ventas con ese codigo(Arbol1): ',cantidadTotal(arbA,cod));
  writeln ('Cantidad de ventas con ese codigo(Arbol2): ',cantidadTotalArbolB(arbB,cod));  
end.

