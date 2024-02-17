{2.- El administrador de un edificio de oficinas cuenta, en papel, con la información del pago de
las expensas de dichas oficinas.
Implementar un programa que invoque a módulos para cada uno de los siguientes puntos:
a. Genere un vector, sin orden, con a lo sumo las 300 oficinas que administra. De cada oficina
se ingresa el código de identificación, DNI del propietario y valor de la expensa. La lectura
finaliza cuando se ingresa el código de identificación -1, el cual no se procesa.}

program puntoDos;
Const
  maxOfi = 300; {Tengo 300 oficinas como máximo}
Type
  subrOfic = 0..maxOfi; {subrango cantidad de oficinas}
  oficina = record  {registro oficina}
    cod: integer;
    dni: integer;
    valExp: real;
  end;
  vOficinas = array [1..maxOfi] of oficina; {vector de oficinas}

{procedimiento para leer cada oficina}
procedure leerOficina(var ofi:oficina); 
begin
  {TESTEO}
  writeln ('Ingrese codigo, dni y valor de expensa en ese orden');
  {-----}
  read(ofi.cod);
  if (ofi.cod<>-1) then begin
    read(ofi.dni);
    read(ofi.valExp);
  end;
end;

{procedimiento para cargar el vector de oficinas (como máximo 300 oficinas)}
procedure cargarVector(var v:vOficinas; var dL:subrOfic);
var
  nuevaOfi:oficina;
  pos:subrOfic;
begin
  pos:=1;
  leerOficina(nuevaOfi);
  while ((pos<>maxOfi) and (nuevaOfi.cod<>-1)) do begin
    v[pos]:=nuevaOfi;
    dL:=pos;
    pos:=pos+1;
    leerOficina(nuevaOfi);
  end;
end;

{b. Ordene el vector, aplicando el método de inserción, por código de identificación de la
oficina.}
procedure insercion (var v:vOficinas; dL:subrOfic);
var
  i,j,pos:subrOfic;
  aux:oficina;
begin
  for i:= 1to(dL-1) do begin
    pos:=i;
    for j:= (i+1)to dL do
     if (v[j].cod < v[pos].cod) then
      pos:=j;
    aux:=v[pos];
    v[pos]:=v[i];
    v[i]:=aux;
  end;
end;

{c. Ordene el vector aplicando el método de selección, por código de 
identificación de la oficina.}
procedure seleccion(var v:vOficinas; dL:subrOfic);
var
  i,j:subrOfic;
  aux:oficina;
begin
  for i:= 2 to dL do begin
    aux:=v[i];
    j:=i-1;
    while ((j>0) and (v[j].cod > aux.cod))do begin
      v[j+1]:=v[j];
      j:=j-1;
    end;
    v[j+1]:=aux;
  end;
end;

var
  v:vOficinas;
  dL,i:subrOfic;
  
begin
  cargarVector(v,dL);
  {TESTEO DE DATOS: CARGA DEL VECTOR DESORDENADO}
  writeln ('VECTOR DESORDENADO');
  for i:= 1 to dL do begin
    writeln ('Oficina',i);
    writeln ('Codigo ',v[i].cod);
    writeln ('DNI ',v[i].dni);
    writeln ('Precio ',v[i].valExp:8:2);
  end;
  {---------------------}
  insercion(v,dL);
  seleccion(v,dL);
  {TESTEO DE DATOS: ORDENO EL VECTOR POR CODIGO}
  writeln ('VECTOR ORDENADO');
  for i:= 1 to dL do begin
    writeln ('Oficina',i);
    writeln ('Codigo ',v[i].cod);
    writeln ('DNI ',v[i].dni);
    writeln ('Precio ',v[i].valExp:8:2);
  end;
  {---------------------}
end.
