{LO TERMINE PERO NO LO CORRI}
{1. Implementar un programa modularizado para una librería que:
a. Almacene los productos vendidos en una estructura eficiente para la búsqueda por
código de producto. De cada producto deben quedar almacenados la cantidad total de
unidades vendidas y el monto total. De cada venta se lee código de venta, código del
producto vendido, cantidad de unidades vendidas y precio unitario. El ingreso de las
ventas finaliza cuando se lee el código de venta -1.}
program puntoUno;
type
  venta = record
    codVent:integer;
    codProd:integer;
    cantUnid:integer;
    precioUnit:real;
  end;
  producto = record
    uniVend:integer;
    montoTot:real;
    codProd:integer;
  end;
  arbol = ^nodo;
  nodo = record
    prod:producto;
    hI:arbol;
    hD:arbol;
  end;
  
{Leo una venta voy al arbol y me fijo donde la agrego}
{Modulo que agrega un nuevo nodo al arbol, mira de agregar ordenado por cod de producto}  
procedure agregar(var a:arbol; v:venta);
begin
  if (a=nil) then begin
    new(a);
    a^.prod.uniVend:=v.cantUnid;
    a^.prod.montoTot:=v.precioUnit*v.cantUnid;
    a^.prod.codProd:=v.codProd;
    a^.hI:=nil;
    a^.hD:=nil;
  end
  else if (v.codProd<a^.prod.codProd) then
    agregar(a^.hI,v)
  else if (v.codProd=a^.prod.codProd) then begin{Si es igual no genero nuevo nodo, sino queactualizo}
    a^.prod.uniVend:=a^.prod.uniVend+v.cantUnid;
    a^.prod.montoTot:=a^.prod.montoTot+v.precioUnit*v.cantUnid;
  end
  else
    agregar(a^.hD,v);
end;

{Modulo que lee una venta}
procedure leerventa(var v:venta);
begin
  read(v.codVent);
  if (v.codVent<>-1)then begin
    read(v.codProd);
    read(v.cantUnid);
    read(v.precioUnit);
  end;
end;

{Modulo de carga del arbol llama un modulo para leer una venta y otro para cargarla al arbol}
procedure cargarArbol(var a:arbol);
var
  v:venta;
begin
  leerventa(v);
  if (v.codVent<>-1) then begin
    agregar (a,v);
    cargarArbol(a);
  end;
end;
{------}

{b. Imprima el contenido del árbol ordenado por código de producto.}
procedure impProducto(p:producto);
begin
  writeln('Codigo de producto: ',p.codProd);
  writeln('Unidades vendidas: ',p.uniVend);
  writeln('Monto Total: ',p.montoTot);
end;

procedure imprimirOrdenado(a:arbol);
begin
  if (a<>nil) then begin
    imprimirOrdenado(a^.hI);
    impProducto(a^.prod);
    imprimirOrdenado(a^.hD);
  end
end;
{------}

{c. Contenga un módulo que reciba la estructura generada en el punto a y retorne el
código de producto con mayor cantidad de unidades vendidas.}
function buscarMasVenta(a:arbol;max:integer):integer;
begin
  if (a<>nil)then begin
    if(a^.prod.uniVend>max)then begin
      max:=a^.prod.uniVend;
      buscarMasVenta:=a^.prod.codProd;
    end;
    buscarMasVenta(a^.hI,max);
    buscarMasVenta(a^.hD,max);
  end;
end;

{d. Contenga un módulo que reciba la estructura generada en el punto a y un código de
producto y retorne la cantidad de códigos menores que él que hay en la estructura.}
function contarCodigosMenores(a:arbol;cod:integer):integer;
begin
  if (a=nil) then
    contarCodigosMenores:=0
  else if (a^.prod.codProd>=cod) then
    contarCodigosMenores(a^.hI,cod)
  else
    contarCodigosMenores:=1+contarCodigosMenores(a^.hI,cod)+contarCodigosMenores(a^.hD,cod);
end;

{e. Contenga un módulo que reciba la estructura generada en el punto a y dos códigos de
producto y retorne el monto total entre todos los códigos de productos comprendidos
entre los dos valores recibidos (sin incluir).}
function sumarEntreDos(a:arbol;cod1,cod2:integer):real;
begin
  if (a<>nil) then begin
    if (a^.prod.codProd>cod1)then
      if (a^.prod.codProd<cod2)then 
        sumarEntreDos:=a^.prod.montoTot+sumarEntreDos(a^.hI,cod1,cod2)+sumarEntreDos(a^.hD,cod1,cod2)
      else
        sumarEntreDos(a^.hI,cod1,cod2)
    else
      sumarEntreDos(a^.hD,cod1,cod2);
  end;
end;

{PROGRAMA PRINCIPAL}
var 
  a:arbol;
  max,cod:integer;
begin
  a:=nil;
  cargarArbol(a);
  imprimirOrdenado(a);
  max:=0;
  writeln('Codigo con mas ventas: ',buscarMasVenta(a,max));
  read(cod);
  writeln('Cantidad de codigos menores: ',contarCodigosMenores(a,cod));
end.
