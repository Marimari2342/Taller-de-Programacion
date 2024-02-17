{EJERCICIO TERMINADO}
{6.- Realizar un programa que lea números y que utilice un módulo recursivo que escriba el
equivalente en binario de un número decimal. El programa termina cuando el usuario ingresa
el número 0 (cero).
Ayuda: Analizando las posibilidades encontramos que: Binario (N) es N si el valor es menor a 2.
¿Cómo obtenemos los dígitos que componen al número? ¿Cómo achicamos el número para la
próxima llamada recursiva? Ejemplo: si se ingresa 23, el programa debe mostrar: 10111}

program puntoSeis;
type
  lista=^nodo;
  nodo = record
    b:integer;
    sig:lista;
  end;

{el modulo hace una lista con todos los digitos del decimal pasado a binario, los guarda 
* del bit menos significativo al mas significativo}
procedure listaDeBinarios(var l:lista; bi:integer);
var
  nuevo:lista;
begin
  new(nuevo);
  nuevo^.b:=bi;
  nuevo^.sig:=nil;
  if (l=nil) then
    l:= nuevo
  else begin
    nuevo^.sig:=l;
    l:=nuevo;
  end;
end;

{el modulo recibe un numero decimal y lo convierte a binario, luego retorna el binario}
procedure binarioRecursivo(num:integer; var l:lista);
var
  aux:integer;
begin
  if (num <> 0) then begin
    if (num MOD 2 = 0) then
      aux:=0
    else
      aux:=1;
    listaDeBinarios(l,aux);
  end;
  if (num <> 0) then begin
    num:=num DIV 2;
    binarioRecursivo(num,l);
  end;
end;

{procedimiento que lee recursivamente la lista con los digitos del numero binario}
procedure leerLista(l:lista);
begin
  if (l<>nil) then begin
    write(l^.b);
    l:=l^.sig;
    leerLista(l);
  end;
end;

{PROGRAMA PRINCIPAL}
var
  num:integer;
  l:lista;
begin
  randomize;
  num:=random(100);
  writeln('Numero decimal: ');
  writeln (num);
  l:=nil;
  binarioRecursivo(num,l);
  writeln('Numero binario: ');
  leerLista(l);
end.
