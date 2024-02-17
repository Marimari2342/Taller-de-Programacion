{EJERCICIO TERMINADO}
{5.- Implementar un módulo que realice una búsqueda dicotómica en un vector, utilizando el
siguiente encabezado:
Procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice);
Nota: El parámetro “pos” debe retornar la posición del dato o -1 si el dato no se encuentra
en el vector.}

program puntoCinco;
const
  dF=20;
type
  indice = -1..20;
  vector = array [1..dF] of integer; 

{procedimiento sacado del ejercicio anterior NO ME LO PIDE ESTE EJERCICIO}
procedure cargarVector(var v:vector; var dL:indice);
begin
  if (dL<dF) then begin
    dL:=dL+1;
    v[dL] := random(30);
    writeln (v[dL]);
    cargarVector(v,dL);
  end;
end;

procedure busquedaDicotomica (v: vector; ini,fin: indice; dato:integer; var pos: indice);
begin 
  if (ini<=fin) then begin
    pos := (ini+fin)DIV 2;
    if (ini<=fin) and (dato <> v[pos]) then begin
      if (dato<v[pos]) then
        fin:= pos-1
      else
        ini:= pos+1;
      busquedaDicotomica (v,ini,fin,dato,pos);
    end;
  end 
  else if (dato = v[pos]) then
    pos:=pos;  
  if (ini>=fin) and (dato <> v[pos]) then
    pos:=-1;
end;

{PROGRAMA PRINCIPAL}
var
  ini,dL,pos:indice;
  v:vector;
  dato:integer;
begin
  randomize;
  dL:=0;
  cargarVector(v,dL);
  ini:=1;
  dato:=random(30);
  writeln ('Dato: ',dato);
  busquedaDicotomica(v,ini,dL,dato,pos);
  if (pos<>-1) then
    writeln ('El numero ingresado se encuentra en el vector')
  else
    writeln ('El numero ingresado NO se encuentra en el vector');
end.
