{YA ESTA TERMINADO}
{2.- Realizar un programa que lea números hasta leer el valor 0 e imprima, para cada número
leído, sus dígitos en el orden en que aparecen en el número. Debe implementarse un módulo
recursivo que reciba el número e imprima lo pedido. Ejemplo si se lee el valor 256, se debe
imprimir 2 5 6 }

program puntoDos;
type
  lista=^nodo;
  nodo = record
    num:integer;
    sig:lista;
  end;

{procedimiento para leer numeros resursivamente, agregándo cada nuevo numero leido al final de
* la lista}
procedure leernumerosRecursivos (var pI,pF:lista);
var
  nuevo:lista;
  aux:integer;
begin
  writeln('Ingrese un numero: ');
  read(aux);
  if (aux<>0) then begin
    new(nuevo);
    nuevo^.num:=aux;
    nuevo^.sig:=nil;
    if (pI=nil) then begin
      pI:=nuevo;
      pF:=nuevo;
    end
    else begin
      pF^.sig:=nuevo;
      pF:=nuevo;
    end;
    leernumerosRecursivos(pI,pF);
  end;
end;

{procedimiento para hacer una lista con los numeros que componen cada numero para leer en orden}
procedure ordenarEnLista(var l:lista; n:integer);
var
  nuevo:lista;
begin
  new(nuevo);
  nuevo^.num:=n;
  nuevo^.sig:=nil;
  if (l=nil) then
    l:=nuevo
  else begin
    nuevo^.sig:=l;
    l:=nuevo;
  end;
end;

{procedimiento para imprimir los digitos ordenados en la lista}
procedure impDigitosRecursivo (l:lista);
begin
  if(l<>nil)then begin
    writeln(l^.num);
    l:=l^.sig;
    impDigitosRecursivo(l);
  end;
end;

{procedimiento para descomponer un numero pasado por parametro}
procedure descomponerNumero(num:integer);
var
  aux:integer;
  l:lista;
begin
  l:=nil;
  while(num<>0) do begin
    aux:=num MOD 10;
    {me guardo aux en una lista}
    ordenarEnLista(l,aux);
    num:=num DIV 10;
  end;
  writeln('Digitos: ');
  impDigitosRecursivo(l);
end;

{procedimiento para ir recorriendo la lista recursivamente y llamando otro modulo que 
* descomponga el numero}
procedure imprimirNumeros(pI:lista);
begin
  if (pI<>nil) then begin
    descomponerNumero(pI^.num);
    pI:=pI^.sig;
    imprimirNumeros(pI);
  end;
end;

{PROGRAMA PRINCIPAL}
var
  pI,pF:lista;
begin
  pI:=nil;
  pF:=nil;
  leernumerosRecursivos(pI,pF);
  imprimirNumeros(pI);
end.
