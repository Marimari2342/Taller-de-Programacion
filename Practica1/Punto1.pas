{1.- Se desea procesar la información de las ventas de productos de un comercio (como máximo
50).
Implementar un programa que invoque los siguientes módulos:
a. Un módulo que retorne la información de las ventas en un vector. De cada venta se conoce el
día de la venta, código del producto (entre 1 y 15) y cantidad vendida (como máximo 99
unidades). El código debe generarse automáticamente (random) y la cantidad se debe leer. El
ingreso de las ventas finaliza con el día de venta 0 (no se procesa).}

program puntoUno;

Const
  maxVenta=99; {unidades maximas vendidas}
  dF=50; {ventas maximas}
  
Type
  fecha = 0..31; {subrango dia}
  codProd = 0..15; {subrango codigos}
  rVentas = 0..maxVenta; {subrango de cantidad de unidades vendidas}
  totProd = 0..dF; {subrango de cantidad de ventas}
  venta = record {registro de venta}
    dia:fecha;
    cod:codProd;
    cant:rVentas;
  end;
  lista = ^nodo; {lista de ventas}
  nodo = record
    dato:venta;
    sig:lista;
  end;
  regxCod = record {registro con una lista de cada codigo y la cantidad total de ventas x cod}
    vent:lista;
    cantTot:integer;
  end;  
  vVentas = array [totProd] of venta; {vector de ventas}
  vCodigos = array [1..7] of regxCod; {vector de listas ordenadas por codigo pares}
      
{modulo con el que leo cada venta}  
procedure leerVenta(var v:venta);
begin
  randomize;
  writeln ('ingrese dia, codigo (1 a 15) y cantidad (max 99)'); 
  read(v.dia);
  if (v.dia<>0) then begin
    v.cod := random(15)+1;
    read(v.cant);
  end;
end;

{modulo para cargar el vector de ventas, a lo sumo 50 ventas}
procedure cargaVector(var v:vVentas; var dL:totProd);
var
  ventaActual:venta;
begin
  dL:=0;
  leerVenta(ventaActual);
  while (ventaActual.dia<>0) and (dL<dF) do begin
    dL:=dL+1;
    v[dL]:=ventaActual;
    leerVenta(ventaActual);
  end;
end;

{b. Un módulo que muestre el contenido del vector resultante del punto a).}
procedure imprimirVector(v:vVentas;dL:totProd);
var
  i:totProd;
begin
  for i := 1 to dL do begin
    writeln('VENTA ',i);
    writeln('fecha ',v[i].dia);
    writeln('codigo de producto ',v[i].cod);
    writeln('cantidad vendida ',v[i].cant);
  end;
end;

{c. Un módulo que ordene el vector de ventas por código.}
procedure ordenarSeleccion(var v:vVentas;dL:totProd);
var
  i,j,pos:totProd;
  aux:venta;
begin
  for i := 1 to (dL-1) do begin
    pos:=i;
    for j := i+1 to dL do
      if (v[j].cod < v[pos].cod) then
        pos:=j;
      aux:= v[pos];
      v[pos]:=v[i];
      v[i]:=aux;
  end;
end;

{e. Un módulo que elimine, del vector ordenado, las ventas con código de producto entre dos
valores que se ingresan como parámetros.}
{busco posición del parámetro inicial}
function buscarPos (v:vVentas; dL:totProd; n1,pos:totProd):totProd;
begin
  while (pos<dL) and (v[pos].cod<n1) do
   pos:=pos+1;
  if (pos<=dL) then
   buscarPos:=pos
  else
   buscarPos:=dL;
end;

{modulo para eliminar las ventas entre dos parametros dados}
procedure eliminarVentas(var v:vVentas; var dL:totProd; n1,n2:totProd);
var
  pos,ini,fin,i:totProd;
begin
  pos:=1;
  ini:=buscarPos(v,dL,n1,pos);
  fin:=buscarPos(v,dL,n2,ini);
  if (ini<>fin) and (ini<>dL) then begin
    for i := ini to dL - (fin-ini) do
     v[i]:= v[i+fin-ini];
    dL:=dL-(fin-ini);
  end;
end;

{g. Un módulo que retorne la información (ordenada por código de producto de menor a
mayor) de cada código par de producto junto a la cantidad total de productos vendidos.}
{inicializo las listas y el contador de cantidades}
procedure iniciarVectorListas(var v:vCodigos);
var
  i:integer;
begin
  for i := 1 to 7 do begin
    new (v[i].vent);
    v[i].cantTot := 0;
  end;
end;

{procedimiento para cargar mi vector con las ventas ordenadas por codigo de producto
* sólo los productos con codigo par, es un vector de listas y tambien tiene las cantidades
* totales por venta}
procedure cargarVCod(var regLis:regxCod;v:venta);
var
  nL:lista;
begin
  new(nL);
  nL^.dato:=v;
  nL^.sig:=nil;
  regLis.cantTot:=regLis.cantTot+v.cant;
  if (regLis.vent=nil)then
    regLis.vent:=nL
  else begin
    nL^.sig:=regLis.vent;
    regLis.vent:=nL;
  end;
end;

{voy a generar un nuevo vector de listas ordenado por codigo}
procedure productosPares(var vCod:vCodigos; var v:vVentas; var dL,dLCod:totProd);
var
  codAct:codProd;
  i:totProd;
begin
  iniciarVectorListas(vCod);
  codAct:=2;
  i:=1;
  while (i<dL) do begin
    while (i<dL) and (v[i].cod<codAct) and (v[i].cod MOD 2 = 0) do {avanzo en el vector hasta llegar a los prod con cod:2}
      i:=i+1;
    dLCod:=0;
    while (i<dL) and (v[i].cod=codAct) do begin
      cargarVCod(vCod[dLCod+1],v[i]);  {cargo el producto en la lista del cod correspondiente}
      i:=i+1;
    end;
    dLCod:=dLCod+1;
    codAct:=codAct+2;
  end;
end;
  
{h. Un módulo que muestre la información obtenida en el punto g).}  
procedure impVenta (v:venta);
begin
  writeln('VENTA TOTAL POR CODIGO');
  writeln('fecha ',v.dia);
  writeln('codigo de producto ',v.cod);  
  writeln('cantidad vendida ',v.cant);
end;

procedure imprimirVectListas(vCod:vCodigos;dLCod:totProd);
var
  i:totProd;
begin
  for i:=1 to dLCod do 
    while (vCod[i].vent<>nil) do begin
      impVenta(vCod[i].vent^.dato);
      vCod[i].vent:=vCod[i].vent^.sig;
    end;
    writeln ('Cantidad de productos vendidos con codigo actual ',vCod[i].cantTot);
end;

  
var
  v:vVentas;
  dL,dLCod,n1,n2:totProd;
  vCod:vCodigos;
begin
  randomize;
  cargaVector(v,dL);
  imprimirVector(v,dL);
  writeln('----');
  ordenarSeleccion(v,dL);
  {d. Un módulo que muestre el contenido del vector resultante del punto c).}
  imprimirVector(v,dL); {el vector es distinto pero puedo usar el mismo módulo ¿¿??}
  {Punto e.}
  writeln('----');
  writeln ('Ingrese dos parametros entre 1 y 15');
  read(n1);
  read(n2);
  eliminarVentas(v,dL,n1,n2);
  {f. Un módulo que muestre el contenido del vector resultante del punto e).}
  imprimirVector(v,dL);
  writeln('----');
  productosPares(vCod,v,dL,dLCod);
  imprimirVectListas(vCod,dLCod);
end.
