program examen2;
type
  srdia=1..31;
  envio=record
    codCli:integer;
    dia:srdia;
    CP:integer;
    peso:real;
  end;
  
  envios=record
    codCli:integer;
    dia:srdia;
    peso:real;
  end;
  lista=^nodoL;
  nodoL=record
    dato:envios;
    sig:lista;
  end;
  regEnv=record
    CP:integer;
    env:lista;
  end;
  
  arbol=^nodo;
  nodo=record
    dato:regEnv;
    hI:arbol;
    hD:arbol;
  end;
  
procedure leerEnvio(var e:envio);
begin
  e.peso:= random(2000)/random(10)+1;
  if(e.peso<>0)then begin
    e.codCli:=random(100)+1;
    e.dia:=random(31)+1;
    e.CP:=random(7500)+1;
  end;
end;

procedure registroNuevo(aux:envio;var e:envios);
begin
  e.codCli:=aux.codCli;
  e.dia:=aux.dia;
  e.peso:=aux.peso;
end;

procedure agregarLista(var l:lista;e:envios);
var
  nuevo:lista;
begin
  new(nuevo);
  nuevo^.dato:=e;
  nuevo^.sig:=nil;
  if (l=nil) then
    l:=nuevo
  else begin
    nuevo^.sig:=l;
    l:=nuevo;
  end;
end;

procedure agregar(var a:arbol;e:envios;cp:integer);
begin
  if (a=nil) then begin
    new(a);
    a^.dato.CP:=cp;
    a^.dato.env:=nil;
    agregarLista(a^.dato.env,e);
    a^.hI:=nil;
    a^.hD:=nil;
  end
  else if (a^.dato.CP=cp)then
    agregarLista(a^.dato.env,e)
  else if (a^.dato.CP<cp)then
    agregar(a^.hI,e,cp)
  else
    agregar(a^.hD,e,cp);
end;

procedure cargarArbol(var a:arbol);
var
  aux:envio;
  e:envios;
begin
  leerEnvio(aux);
  if(aux.peso<>0)then begin
    registroNuevo(aux,e);
    agregar(a,e,aux.CP);
    cargarArbol(a)
  end;
end;

function retornarEnviosCP (a:arbol;cp:integer):lista;
begin
  if(a=nil)then
    retornarEnviosCP:=nil
  else if(a^.dato.CP=cp)then 
    retornarEnviosCP:=a^.dato.env
  else if (a^.dato.CP<cp)then
    retornarEnviosCP(a^.hI,cp)
  else 
    retornarEnviosCP(a^.hD,cp);
end;

procedure devolverMayorMenor(l:lista;var max,min:integer;pMax,pMin:real);
begin
  if(l<>nil)then begin
    if(l^.dato.peso>pMax)then begin
      pMax:=l^.dato.peso;
      max:=l^.dato.codCli;
    end;
    if(l^.dato.peso<pMin)then begin
      pMin:=l^.dato.peso;
      min:=l^.dato.codCli;
    end;
    devolverMayorMenor(l^.sig,max,min,pMax,pMin);
  end;
end;

var
  a:arbol;
  cp:integer;
  listaVenta:lista;
  max,min:integer;
  pMax,pMin:real;
begin
  randomize;
  a:=nil;
  cargarArbol(a);
  read(cp);
  listaVenta:=retornarEnviosCP(a,cp);
  pMax:=0;
  pMin:=2000;
  devolverMayorMenor(listaVenta,max,min,pMax,pMin);
end.
