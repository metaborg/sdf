#!/usr/bin/env bash

SUNSHINE_PATH = "/Users/eduardo/spoofax-releng-newCompletions/spoofax-sunshine/org.metaborg.sunshine/target/org.metaborg.sunshine-1.5.0-SNAPSHOT-shaded.jar"

set -e

printf "========================================================================================================================================================\n"
printf "Generating sdf2table parse tables:\n"

echo "FILES FOUND:"
for f in $(echo $(ls | grep ".sdf"))
 do
   echo $f
 done

for f in $(echo $(ls | grep ".sdf"))
 do
 	FILENAME=$(echo $f | sed 's/.sdf//g')	
 	echo $FILENAME

 	pack-sdf -i $f -o $FILENAME.def
 	sdf2table -m $FILENAME -i $FILENAME.def -o $FILENAME.tbl -t
 	pp-aterm -i $FILENAME.tbl -o $FILENAME-pp.tbl

 done

shopt -s extglob 	
rm -- !(*.sdf|*-pp.tbl)

printf "========================================================================================================================================================\n"
printf "Generating stratego parse tables:\n"

cd ../sdf3/

for f in $(echo $(ls | grep ".sdf3"))
 do
   FILENAME=$(echo $f | sed 's/.sdf3//g')	

   java -cp $SUNSHINE_PATH org/metaborg/sunshine/drivers/Main --auto-lang ../../include --project $PROJECT_PATH --non-incremental --builder "to Normal Form" --build-on tests/normalization/unity/$f

 done