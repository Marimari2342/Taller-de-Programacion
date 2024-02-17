program examenTres;
const
  dF=12;
type
  submes=1..12;
  compra=record
    monto:real;
    cliente:integer;
    mes:submes;
  end;
  
  vectorMes=array[submes]of real;
  cliComp=record
    cliente:integer;
    vMes:vectorMes;
  end;
  arbol=^nodoA;
  nodoA=record
    dato:cliComp;
    hI:arbol;
    hD:arbol;
  end;

{Punto a)}  
procedure cargaArbol(var a:arbol);
  
procedure leerCompra(var c:compra);
begin
  c.cliente:=random(100);
  if (c.cliente<>0)then begin
    c.monto:=random(20000)/random(10)+1;
    c.mes:=random(12)+1;
  end;
end;

procedure agregar(var a:arbol;c:compra);

procedure vectorCero(var v:vectorMes);
var
  i:integer;
begin
  for i:=1 to dF do
    v[i]:=0;
end;

procedure cargaVector(var v:vectorMes;c:compra);
begin
  v[c.mes]:=v[c.mes]+c.monto;
end;

begin
  if(a=nil)then begin
    new(a);
    a^.dato.cliente:=c.cliente;
    vectorCero(a^.dato.vMes);
    cargaVector(a^.dato.vMes,c);
    a^.hI:=nil;
    a^.hD:=nil;
  end
  else if (a^.dato.cliente=c.cliente)then
    cargaVector(a^.dato.vMes,c)
  else if (a^.dato.cliente>c.cliente)then
    agregar(a^.hI,c)
  else
    agregar(a^.hD,c);
end;

var
  aux:compra;
begin
  leerCompra(aux);
  if(aux.cliente<>0)then begin
    agregar(a,aux);
    cargaArbol(a);
  end;
end;

{Punto b)}
function mayorGasto(a:arbol;cli:integer):integer;

function buscarMaximo(v:vectorMes;max:real;i,mMax:integer):integer;
begin
  if (i<=dF) then
    if (v[i]>max) then begin
      max:=v[i];
      mMax:=i;
    end;
    buscarMaximo:=buscarMaximo(v,max,i+1,mMax);
  buscarMaximo:=mMax;
end;

var
  max:real;
  i,mMax:integer;
begin
  if(a=nil)then
    mayorGasto:=0
  else if (a^.dato.cliente=cli) then begin
    max:=0;
    i:=1;
    mayorGasto:=buscarMaximo(a^.dato.vMes,max,i,mMax);
  end
  else if(a^.dato.cliente<cli) then
    mayorGasto:=mayorGasto(a^.hD,cli)
  else
    mayorGasto:=mayorGasto(a^.hD,cli);
end;

{Punto c)}
function cliSinGastos(a:arbol;mes:submes):integer;
begin
  if(a=nil)then
    cliSinGastos:=0
  else if(a<>nil)then
    if (a^.dato.vMes[mes]=0)then
      cliSinGastos:=1+cliSinGastos(a^.hI,mes)+cliSinGastos(a^.hD,mes);
end;

var 
  a:arbol;
  cli:integer;
  mes:submes;
begin
  randomize;
  cargaArbol(a);
  read(cli);
  writeln('Mes con mayor gasto del cliente ingresado: ',mayorGasto(a,cli));
  read(mes);
  writeln('Clientes sin gastos: ',cliSinGastos(a,mes));
end.
