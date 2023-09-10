{TERMINADO PERO NO LO CORRÍ, SOLO LO COMPILE}
{1. Escribir un programa que:
a. Implemente un módulo que lea información de socios de un club y las almacene en un árbol
binario de búsqueda. De cada socio se lee número de socio, nombre y edad. La lectura finaliza
con el número de socio 0 y el árbol debe quedar ordenado por número de socio.}

program puntoUno;
type
  socio = record
    num:integer;
    nombre:string;
    edad:integer;
  end;
  arbol=^nodo;
  nodo = record
    per:socio;
    hI:arbol;
    hD:arbol;
  end;
  
{procedimiento de lectura de un socio}
procedure leerSocio(var s:socio);
begin
  writeln('ingrese codigo de socio, nombre y edad');
  readln (s.num);
  if (s.num<>0) then begin
    readln (s.nombre);
    readln (s.edad);
  end;
end;

{procedimiento para agregar datos nuevos al arbol}
procedure agregar(var a:arbol; soc:socio);
begin
  if (a=nil) then begin {caso borde}
    new(a);
    a^.per:=soc;
    a^.hI:=nil;
    a^.hD:=nil;
  end
  else if (soc.num <= a^.per.num) then
    agregar(a^.hI,soc)
  else
    agregar(a^.hD,soc);
end;

{procedimiento de carga del arbol}
procedure cargaArbol(var a:arbol);
begin
  leerSocio(a^.per);
  while (a^.per.num<>0) do begin
    agregar(a,a^.per);
    leerSocio(a^.per);
  end;
end;

{MODULO QUE: i. Informe el número de socio más grande. Debe invocar a un módulo recursivo que
retorne dicho valor.}
function maximoNumSocio (a:arbol):integer;
begin
  if(a^.hD=nil) then
    maximoNumSocio:=a^.per.num
  else 
    maximoNumSocio:=maximoNumSocio(a^.hD);
end;

{MODULO QUE: ii. Informe los datos del socio con el número de socio más chico. Debe invocar a un módulo
recursivo que retorne dicho socio.}
function minimoSocio (a:arbol):arbol;
begin
  if(a=nil) then
    minimoSocio:=nil
  else if(a^.hI=nil) then
    minimoSocio:=a
  else 
    minimoSocio:=minimoSocio(a^.hD);
end;

{MODULO QUE: iii. Informe el número de socio con mayor edad. Debe invocar a un módulo recursivo que
retorne dicho valor.}
{Tengo que recorrer si o si todo el arbol puesto que esta ordenado por codigo, no por edad ¿??}
procedure maxEdadNumSocio(a:arbol; edMax:integer; var codMax:integer);
begin
  if (a<>nil)then begin
    maxEdadNumSocio(a^.hI,edMax,codMax);
    if (a^.per.edad>=edMax) then begin
      edMax:=a^.per.edad;
      codMax:=a^.per.num;
    end;
    maxEdadNumSocio(a^.hD,edMax,codMax);
  end;
end;

{MODULO QUE: iv. Aumente en 1 la edad de todos los socios.}
procedure sumoUnAnio(a:arbol);
begin
  if (a<>nil)then begin
    sumoUnAnio(a^.hI);
    a^.per.edad:=a^.per.edad+1;
    sumoUnAnio(a^.hD);
  end;
end;

{MODULO QUE: v. Lea un valor entero e informe si existe o no existe un socio con ese valor. Debe invocar a
un módulo recursivo que reciba el valor leído y retorne verdadero o falso.}
{Voy a suponer que por valor se refiere al codigo, entonces leo ordenado}
function existeSocio (a:arbol;num:integer):boolean;
begin
  if (a=nil) then
    existeSocio:=false
  else if (a^.per.num=num) then
    existeSocio:=true
  else if (a^.per.num>=num) then
    existeSocio:=existeSocio(a^.hI,num)
  else
    existeSocio:=existeSocio(a^.hD,num);
end;

{MODULO QUE: vi. Lea un nombre e informe si existe o no existe un socio con ese nombre. 
* Debe invocar a un módulo recursivo que reciba el nombre leído y retorne verdadero o falso.}
function existeNombre(a:arbol;nom:string):boolean;
begin
  if (a<>nil)then begin
    if (a^.per.nombre=nom) then
      existeNombre:=true
    else begin
    existeNombre:=existeNombre(a^.hI,nom);
    existeNombre:=existeNombre(a^.hD,nom);
    end;
  end
  else
    existeNombre:=false
end;

{MODULO QUE: vii. Informe la cantidad de socios. Debe invocar a un módulo recursivo 
* que retorne dicha cantidad.}
function cantidadDeSocios(a:arbol):integer;
begin
  if (a<>nil) then
    cantidadDeSocios:=cantidadDeSocios(a^.hI)+cantidadDeSocios(a^.hI)+1
  else
    cantidadDeSocios:=0;
end;

{MODULO QUE: viii. Informe el promedio de edad de los socios. Debe invocar al módulo 
* recursivo del inciso vii e invocar a un módulo recursivo que 
* retorne la suma de las edades de los socios.}
function sumarEdad(a:arbol):integer;
begin
  if (a<>nil) then
    sumarEdad:=sumarEdad(a^.hI)+sumarEdad(a^.hI)+a^.per.edad
  else
    sumarEdad:=0;
end;

function promedioEdad(a:arbol):real;
begin
  promedioEdad:=sumarEdad(a)/cantidadDeSocios(a);
end;
{-----}

{MODULO QUE: xi. Informe los números de socio en orden creciente.}
procedure informarCreciente(a:arbol);
begin
  if (a<>nil) then begin
    informarCreciente(a^.hI);
    writeln(a^.per.num);
    informarCreciente(a^.hD);
  end;    
end;
{MODULO QUE: x. Informe los números de socio pares en orden decreciente.}
procedure informarDecreciente(a:arbol);
begin
  if (a<>nil) then begin
    informarDecreciente(a^.hD);
    writeln(a^.per.num);
    informarDecreciente(a^.hI);
  end;    
end;

{PROGRAMA PRINCIPAL}
var
  a,minSoc:arbol;
  maxCod,codEdadMax,edMax,num:integer;
  nom:string;
  
begin
  a:=nil;
  cargaArbol(a);
  if(a<>nil)then begin
    maxCod:=maximoNumSocio(a);
    writeln ('El numero de socio mas grande es: ',maxCod);
  end;
  minSoc:=minimoSocio(a);
  writeln ('La persona con el numero de socio menor es:');
  writeln ('	Numero de socio: ',minSoc^.per.num);
  writeln ('	Nombre: ',minSoc^.per.nombre);
  writeln ('	Edad: ',minSoc^.per.edad);
  edMax:=0;
  maxEdadNumSocio(a,edMax,codEdadMax);
  sumoUnAnio(a);
  read(num);
  if (existeSocio(a,num))then
    writeln('Existe un socio con ese codigo')
  else 
    writeln('NO Existe un socio con ese codigo'); 
  read(nom);
  writeln('Existe el nombre: ',existeNombre(a,nom));
  writeln ('Cantidad de socios: ',cantidadDeSocios(a));
  writeln ('Edad Promedio: ',promedioEdad(a));
end.
