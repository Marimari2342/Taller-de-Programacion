{ESTE EJERCICIO ESTA TERMINADO}
{3.- Escribir un programa que:
a. Implemente un módulo recursivo que genere una lista de números enteros “random”
mayores a 0 y menores a 100. Finalizar con el número 0.}

program puntoTres;
type
  srNum = 0..100;
  lista = ^nodo;
  nodo = record
    num:srNum;
    sig:lista;
  end;

{procedimiento recursivo que genera una lista con enteros random entre 0 y 100}  
procedure crearLista(var pI:lista);
var
  nuevo:lista;
  aux:srNum;
begin
  aux:= random (20);
  if (aux<>0)then begin
    new(nuevo);
    nuevo^.num := aux;
    nuevo^.sig:=nil;
    if (pI=nil) then
      pI:=nuevo
    else begin
      nuevo^.sig:=pI;
      pI:=nuevo;
    end;
    crearLista(pI);
  end;
end;

{b. Implemente un módulo recursivo que devuelva el mínimo valor de la lista.}
procedure valorMinimo (pI:lista; var min:srNum);
begin
  if (pI<>nil) then begin
    if (pI^.num < min) then
      min := pI^.num;
    pI:= pI^.sig;
    valorMinimo (pI,min);
  end; 
end;  

{c. Implemente un módulo recursivo que devuelva el máximo valor de la lista.}
procedure valorMaximo (pI:lista; var max:srNum);
begin
  if (pI<>nil) then begin
    if (pI^.num > max) then
      max := pI^.num;
    pI:= pI^.sig;
    valorMaximo (pI,max);
  end; 
end;  

{d. Implemente un módulo recursivo que devuelva verdadero si un valor determinado se
encuentra en la lista o falso en caso contrario.}
function estaElValor (pI:lista;num:srNum):boolean;
var
  ok:boolean;
begin
  if (pI<>nil) then
    if(pI^.num = num) then 
      estaElValor:=true
    else begin
      pI:=pI^.sig;
      estaElValor:=estaElValor(pI,num);    
    end
  else if (pI=nil) then
    estaElValor:=false;
end;

{TESTEO}
procedure leerLista(pI:lista);
begin
  if (pI<>nil) then begin
    writeln(pI^.num);
    pI:=pI^.sig;
    leerLista(pI);
  end;
end;
{-------}

{PROGRAMA PRINCIPAL}
var
  pI:lista;
  min,max,val:srNum;
begin
  randomize;
  pI:=nil;
  crearLista(pI);
  {------}
  leerLista(pI);
  {------}
  min:=100;
  max:=0;
  valorMinimo(pI,min);
  valorMaximo(pI,max);
  writeln ('Minimo: ',min,' - Maximo: ',max);
  writeln('Ingrese un valor entre 0 y 100');
  read(val);
  if (estaElValor(pI,val)) then
    writeln('el valor se encuentra en la lista')
  else
    writeln('el valor NO se encuentra en la lista');
end.
