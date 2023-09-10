{TERMINADO, COMPILA PERO NO LO CORRI}
{3. Implementar un programa que contenga:
a. Un módulo que lea información de alumnos de Taller de Programación y los almacene en
una estructura de datos. De cada alumno se lee legajo, DNI, año de ingreso y los códigos y
notas de los finales rendidos. La estructura generada debe ser eficiente para la búsqueda por
número de legajo. La lectura de los alumnos finaliza con legajo 0 y para cada alumno el ingreso
de las materias finaliza con el código de materia -1.}

program puntoTres;
type
  srAnio = 1950..2023;
  sbNota = 1..10;
  regFin = record
    cod:integer;
    nota:sbNota;
  end;
  lista = ^nodo;
  nodo = record
    finales:regFin;
    sig:lista;
  end;
  alumno = record
    legajo:integer;
    dni:integer;
    anioIng:srAnio;
    notas:lista;
  end;
  arbol = ^nodoA;
  nodoA = record
    alu:alumno;
    hI:arbol;
    hD:arbol;
  end;
  dniAnioIng = record
    dni:integer;
    anioIng:srAnio;
  end;
  lisDniIng=^nodoDI;
  nodoDI = record
    dato:dniAnioIng;
    sig:lisDniIng;
  end;
  mejAlu = record
    legajo:integer;
    prom:real;
  end;
  listaSup =^nodoSup;
  nodoSup = record
    alu:mejAlu;
    sig:listaSup;
  end;

{procedimientos para leer alumnos y cargar lista de notas del mismo}
procedure leerNota(var aux:regFin);
begin
  read(aux.cod);
  if (aux.cod<>-1)then
    read(aux.nota);
end;

procedure cargarNotas(var n:lista);
var
  nuevo:lista;
  aux:regFin;
begin
  leerNota(aux);
  if(aux.cod<>-1) then begin
    new(nuevo);
    nuevo^.finales:=aux;
    nuevo^.sig:=nil;
    if (n=nil) then
      n:=nuevo
    else begin
      nuevo^.sig:=n;
      n:=nuevo;
    end;
    cargarNotas(n);
  end;
end;

procedure leerAlumno(var a:alumno);
begin
  read(a.legajo);
  if (a.legajo<>0) then begin
    read(a.dni);
    read(a.anioIng);
    a.notas:=nil;
    cargarNotas(a.notas);
  end;
end;
{-----}

{procedimiento que agrega un nuevo alumno al arbol}
procedure agregar(var a:arbol;alu:alumno);
begin
  if (a=nil) then begin
    new(a);
    a^.alu:=alu;
    a^.hI:=nil;
    a^.hD:=nil;  
  end
  else if (alu.legajo<=a^.alu.legajo) then
    agregar(a^.hI,alu)
  else
    agregar(a^.hD,alu);
end;

{este procdimiento lee alumnos y los agrega al arbol hasta ingresar el legajo 0}
procedure crearArbol(var a:arbol);
var
  aux:alumno;
begin
  leerAlumno(aux);
  if (aux.legajo<>0) then begin
    agregar(a,aux);
    crearArbol(a);
  end;
end;

{b. Un módulo que reciba la estructura generada en a. y retorne los DNI y año de ingreso de
aquellos alumnos cuyo legajo sea inferior a un valor ingresado como parámetro.}
procedure cargarListaConDniyAnioIng(dni:integer;anio:srAnio;var l:lisDniIng);
var
  nuevo:lisDniIng;
begin
  new(nuevo);
  nuevo^.dato.dni:=dni;
  nuevo^.dato.anioIng:=anio;
  nuevo^.sig:=nil;
  if (l=nil) then
    l:=nuevo
  else begin
    nuevo^.sig:=l;
    l:=nuevo;
  end;
end;

procedure listaDeDniyAnioIngreso(a:arbol;leg:integer;var dniEIng:lisDniIng);
begin
  if (a<>nil) then
    if (a^.alu.legajo<leg)then begin {si es menor reviso todo ese subarbol}
      cargarListaConDniyAnioIng(a^.alu.dni,a^.alu.anioIng,dniEIng);
      listaDeDniyAnioIngreso(a^.hI,leg,dniEIng);
      listaDeDniyAnioIngreso(a^.hD,leg,dniEIng);
    end
    else {si es mayor o igual me voy al hijo izquierdo}
      listaDeDniyAnioIngreso(a^.hI,leg,dniEIng);
end;
{--------}

{c. Un módulo que reciba la estructura generada en a. y retorne el legajo más grande.}
function mayorlegajo(a:arbol):integer;
begin
  if (a<>nil) then
    mayorlegajo(a^.hD)
  else 
    mayorlegajo:=a^.alu.legajo;
end;

{d. Un módulo que reciba la estructura generada en a. y retorne el DNI más grande.}
function mayorDni(a:arbol;mayor:integer):integer;
begin
  if(a<>nil) then begin
    mayorDni(a^.hI,mayor);
    if (mayor<a^.alu.dni) then
      mayor:=a^.alu.dni;
    mayorDni:=mayor;
    mayorDni(a^.hD,mayor);
  end;
end;

{e. Un módulo que reciba la estructura generada en a. y retorne la cantidad de alumnos con
legajo impar.}
function impares (a:arbol):integer;
begin
  if (a<>nil) then
    impares:=impares(a^.hI)+impares(a^.hD)+(a^.alu.legajo MOD 2)
  else
    impares:=0;
end;

{e. Un módulo que reciba la estructura generada en a. y retorne el legajo y el promedio del
alumno con mayor promedio.}
procedure sacarPromedio(n:lista;var prom:real);
var 
  cant,suma:integer;
begin
  suma:=0;
  cant:=0;
  while (n<>nil) do begin
    suma:=suma+n^.finales.nota;
    cant:=cant+1;
    n:=n^.sig;
  end;
  prom:=suma/cant;
end;

procedure mayorPromedio (a:arbol; var alu:mejAlu);
var
  promedio:real;
begin
  if (a<>nil) then begin
    mayorPromedio(a^.hI,alu);
    sacarPromedio(a^.alu.notas,promedio);
    if (promedio>=alu.prom) then begin
      alu.legajo:=a^.alu.legajo;
      alu.prom:=promedio;
    end;
    mayorPromedio(a^.hD,alu);
  end;
end;
{-----}

{f. Un módulo que reciba la estructura generada en a. y un valor entero. Este módulo debe
retornar los legajos y promedios de los alumnos cuyo promedio supera el valor ingresado.}
procedure agregarListaSupera(var lSup:listaSup;promedio:real;legajo:integer);
var
  aux:listaSup;
begin
  new(aux);
  aux^.alu.legajo:=legajo;
  aux^.alu.prom:=promedio;
  aux^.sig:=nil;
  if(lSup=nil)then
    lSup:=aux
  else begin
    aux^.sig:=lSup;
    lSup:=aux;
  end;
end;

procedure promedioSupera (a:arbol;num:integer;var lSup:listaSup);
var
  promedio:real;
begin
  if (a<>nil) then begin
    promedioSupera(a^.hI,num,lSup);
    sacarPromedio(a^.alu.notas,promedio); {uso el mismo modulo que use en el inciso anterior}
    if (promedio>num) then
      agregarListaSupera(lSup,promedio,a^.alu.legajo);
    promedioSupera(a^.hD,num,lSup);
  end;
end;
{PROGRAMA PRINCIPAL}
var
  a:arbol;
  lis:lisDniIng;
  leg,may,num:integer;
  alu:mejAlu;
  lSup:listaSup;
begin
  a:=nil;
  crearArbol(a);
  read(leg);
  lis:=nil;
  listaDeDniyAnioIngreso(a,leg,lis);
  writeln ('Mayor legajo: ',mayorlegajo(a));
  may:=0;
  writeln('Mayor DNI: ',mayorDni(a,may));
  writeln('Cantidad de alumnos con legajo impar: ',impares(a));
  alu.prom:=0;
  mayorPromedio(a,alu);
  lSup:=nil;
  read(num);
  promedioSupera(a,num,lSup);
end.
