program examenUno;
const
  dF=12;
type
  sub_dia=1..31;
  sub_mes=1..12;
  compra=record
    videojuego:integer;
    cliente:integer;
    dia:sub_dia;
    mes:sub_mes;
  end;
  arbol=^nodoA;
  nodoA=record
    dato:compra;
    hI:arbol;
    hD:arbol;
  end;

  vectorMeses=array[sub_mes]of integer;
  
  compraXCliente=record
    videojuego:integer;
    dia:sub_dia;
    mes:sub_mes;
  end;
  lista=^nodoComp;
  nodoComp=record
    dato:compraXCliente;
    sig:lista;
  end;
  
{modulo que lee una compra}  
procedure leerCompra(var c:compra);
begin
  c.cliente=random(100);
  if(c.cliente<>0)then begin
    c.dia:=random(31)+1;
    c.mes:=random(12)+1;
    c.videojuego:=random(20000)+1;
  end;
end;

{modulo para agregar un nuevo nodo al arbol eficiente por cod cliente}
procedure agregar(var a:arbol;c:compra);
var
  nuevo:arbol;
begin
  if(a=nil)then begin
    new(nuevo);
    nuevo^.dato:=c;
    nuevo^.hI:=nil;
    nuevo^.hD:=nil;
    a:=nuevo;
  end
  else if (c.cliente<=a^.dato.cliente)then
    agregar(a^.hI,c)
  else 
    agregar(a^.hD,c);
end;
  
{procedimiento recursivo que llama a un modulo para leer una compra y a otro para agregar la
* compra al arbol y al vector de meses}
procedure crearArbolyVector(var a:arbol;var v:vectorMeses);
var 
  c:compra;
begin
  leerCompra(c);
  if(c.cliente<>0)then begin
    agregar(a,c);
    v[c.mes]:=v[c.mes]+1;
    crearArbolyVector(a,v);
  end;
end;

{Vector de listas en nil}
procedure vectorCero(var v:vectorMeses);
var
  i:integer;
begin
  for i:=1 to dF do
    v[i]:=0;
end;

procedure agregarLista(dato:compra,l:lista);
var 
  nuevo:lista;
begin
  new(nuevo);
  nuevo^.dato.videojuego:=dato.videojuego;
  nuevo^.dato.dia:=dato.dia;
  nuevo^.dato.mes:=dato.mes;
  nuevo^.sig:=nil;
  if (l=nil)then
    l:=nuevo
  else begin
    nuevo^.sig:=l;
    l:=nuevo;
  end;
end;  

{modulo que busca en el arbol el numero de cliente y arma una lista con las compras del mismo}
procedure comprasDelCliente(a:arbol;numCli:integer;compCli:lista);
begin
  if(a<>nil)then begin
    if(numCli=a^.dato.cliente)then
      agregarLista(a^.dato,compCli);     
    if(numCli<=a^.dato.cliente)then
      comprasDelCliente(a^.hI,numCli,compCli)
    else if (numCli>=a^.dato.cliente) then 
      comprasDelCliente(a^.hD,numCli,compCli);
  end;
end;

var
  a:arbol;
  v:vectorMeses;
  l:lista;
  codCli:integer;
begin
  randomize;
  a:=nil;
  vectorCero(v);
  crearArbolyVector(a,v);
  l:=nil;
  read(codCli);
  comprasDelCliente(a,codCli,l);
end.
