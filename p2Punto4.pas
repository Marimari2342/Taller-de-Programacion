{ESTE EJERCICIO ESTA PERFECTO}
{4.- Escribir un programa con:
a. Un módulo recursivo que retorne un vector de 20 números enteros “random” mayores a 0 y
menores a 100.}

program puntoCuatro;
const
  dF = 20;
type
  srDim = 0..dF;
  srNum = 0..100;
  vecNum = array [1..dF] of srNum;

{modulo recursivo de carga del vector de modo random}
procedure cargarVector(var v:vecNum; var dim:srDim);
begin
  if (dim<dF) then begin
    dim:=dim+1;
    v[dim] := random(100);
    writeln (v[dim]);
    cargarVector(v,dim);
  end;
end;

{b. Un módulo recursivo que devuelva el máximo valor del vector.}
procedure valorMaximo(v:vecNum; dim:srDim; var max:srNum);
begin
  if (dim<>0) then begin
    if (v[dim]>max) then
      max:= v[dim];
    dim:=dim-1;
    valorMaximo(v,dim,max);
  end;
end;

{c. Un módulo recursivo que devuelva la suma de los valores contenidos en el vector.}
procedure sumarRecursivo(v:vecNum; dim:srDim; var tot:integer);
begin
  if (dim<>0) then begin
    tot:=tot+v[dim];
    dim:=dim-1;
    sumarRecursivo(v,dim,tot);
  end;
end;

var
  v:vecNum;
  dim:srDim;
  max:srNum;
  tot:integer;
begin
  randomize;
  dim:=0;
  cargarVector(v,dim); 
  max:=0;
  valorMaximo(v,dim,max);
  writeln('El valor maximo hallado en el vector es: ',max);
  tot:=0;
  sumarRecursivo(v,dim,tot);
  writeln('La suma de los valores del vector es: ',tot);
end.
