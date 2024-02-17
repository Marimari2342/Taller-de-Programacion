{REVISAR MAÑANA EL PUNTO C) DE BUSQUEDA DICOTÓMICA}
{1. El administrador de un edificio de oficinas, cuenta en papel, con la información del pago
de las expensas de dichas oficinas. Implementar un programa con:
a) Un módulo que retorne un vector, sin orden, con a lo sumo las 300 oficinas que
administra. Se debe leer, para cada oficina, el código de identificación, DNI del
propietario y valor de la expensa. La lectura finaliza cuando llega el código de
identificación -1.}

program puntoUno;
const
  dF=300;
type
  srCantOfi = 0..dF;
  oficina = record
    cod:integer;
    dni:integer;
    exp:real;
  end;
  vOficina = array [1..dF] of oficina;

{procedimiento para leer una oficina}
procedure leerOficina(var ofi:oficina);
begin
  read(ofi.cod);
  if (ofi.cod<>-1) then begin
    read(ofi.dni);
    read(ofi.exp);
  end;
end;

{procedimiento para cargar un vector de oficinas}
procedure cargarVectorOficinas (var v:vOficina;var dL:srCantOfi);
var
  aux:oficina;
begin
  if(dL<dF)then begin
    leerOficina(aux);
    if (aux.cod<>-1) then begin
      dL:=dL+1;
      v[dL]:=aux;
      cargarVectorOficinas(v,dL);
    end;
  end;
end;
{------}

{b) Un módulo que reciba el vector retornado en a) y retorne dicho vector ordenado por
código de identificación de la oficina. Ordenar el vector aplicando uno de los métodos
vistos en la cursada.}
procedure ordenarVectorPorCod (var v:vOficina;dL:srCantOfi);
var
  i,j,pos:srCantOfi;
  aux:oficina;
begin
  for i:=1 to (dL-1) do begin
    pos:=i;
    for j:= i+1 to dL do
      if (v[j].cod<v[pos].cod) then
        pos:=j;
    aux:=v[pos];
    v[pos]:=v[i];
    v[i]:=aux;
  end;
end;

{c) Un módulo que realice una búsqueda dicotómica. Este módulo debe recibir el vector
generado en b) y un código de identificación de oficina. En el caso de encontrarlo, debe
retornar la posición del vector donde se encuentra y en caso contrario debe retornar 0.
Luego el programa debe informar el DNI del propietario o un cartel indicando que no
se encontró la oficina.}
function busquedaDicotomica (v:vOficina;ini,dL:srCantOfi;cod:integer):srCantOfi;
var
  pos:srCantOfi;
begin
  if (ini<=dL) then begin
    pos:=(ini+dL)DIV 2;
    if (ini<=dL) and (cod<>v[pos].cod) then begin
      if (cod<v[pos].cod) then
        dL:=pos-1
      else
        ini:=pos+1;
      busquedaDicotomica (v,ini,dL,cod);
    end;
  end;
  if (cod = v[pos].cod) then
    busquedaDicotomica:=pos
  else
    busquedaDicotomica:=0;
end;

{d) Un módulo recursivo que retorne el monto total de las expensas.}
function montoTotal(v:vOficina;dL:srCantOfi):real;
begin
  if (dL<>0) then
    montoTotal:=v[dL].exp + montoTotal(v,(dL-1));
end;

{PROGRAMA PRINCIPAL}
var
  v:vOficina;
  dL,ini:srCantOfi;
  cod:integer;
begin
  dL:=0;
  cargarVectorOficinas(v,dL);
  ordenarVectorPorCod(v,dL);
  read(cod);
  ini:=1;
  writeln ('Posicion hallada: ',busquedaDicotomica(v,ini,dL,cod));
  writeln ('Monto total de expensas: ',montoTotal(v,dL));
end.
