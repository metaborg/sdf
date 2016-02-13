#!/usr/bin/env bash

ECLIPSE_PATH="/Applications/eclipse-spoofax-sandbox/plugins"
STRATEGOXT_PATH="$ECLIPSE_PATH/org.strategoxt.strj_1.3.0.20150112-093748//java/strategoxt.jar"
NATIVE_PREFIX="$ECLIPSE_PATH/org.strategoxt.imp.nativebundle_1.3.0.20150112-093748/native/macosx"
PROJECT_PATH="../../../org.strategoxt.imp.editors.template/"
SUNSHINE_PATH="../../../../spoofax-sunshine/org.spoofax.sunshine/target/org.metaborg.sunshine-1.3.0-SNAPSHOT-shaded.jar"

set -e

# parse the options
while getopts 'e:c:' opt ; do
  case $opt in
    e) ECLIPSE_PATH=$OPTARG ;;
  esac
  case $opt in
  	c) echo "cleaning" ;;
  esac
done

mkdir -p unity/normalized


printf "========================================================================================================================================================\n"
printf "Generating Normalized Grammars:\n"

echo "FILES FOUND:"
for f in $(echo $(ls unity | grep ".sdf3"))
 do
   echo $f
 done
 
 printf "\n\n*****   Using sdf2table   *****\n"


# generates .sdf files from .sdf3 files via sunshine
 for f in $(echo $(ls unity | grep ".sdf3"))
 do
   echo $f
   FILENAME=$(echo $f | sed 's/.sdf3//g')	
   SDF_FILE=$(echo $f | sed 's/sdf3/sdf/g')
   if [ ! -f "unity/$FILENAME-normalized.sdf" ]
   then
     java -cp $SUNSHINE_PATH org/metaborg/sunshine/drivers/Main --auto-lang ../../include --project $PROJECT_PATH --non-incremental --builder "Generate SDF (concrete)" --build-on tests/normalization/unity/$f
     mv -v ../../src-gen/syntax/$SDF_FILE unity/$SDF_FILE
   else
   	 echo "unity/$FILENAME-normalized.sdf already exists"
   fi 
   #
 done

# generates all normalized grammars using sdf2table
 ant -lib $STRATEGOXT_PATH main -Declipse.spoofaximp.nativeprefix=$NATIVE_PREFIX

printf "\n\n*****   Using SDF3 builder   *****\n"
# generates *-normalized.sdf files from .sdf3 files via sunshine
 for f in $(echo $(ls unity | grep ".sdf3"))
 do
   FILENAME=$(echo $f | sed 's/.sdf3//g')	
   SDF_FILE=$(echo $f | sed 's/sdf3/sdf/g')
   if [ ! -f "unity/normalized/$FILENAME-normalized.sdf" ]
   then
     java -cp $SUNSHINE_PATH org/metaborg/sunshine/drivers/Main --auto-lang ../../include --project $PROJECT_PATH --non-incremental --builder "to Normal Form" --build-on tests/normalization/unity/$f
     mv -v ../../src-gen/syntax/$FILENAME-normalized.sdf unity/normalized/$FILENAME-normalized.sdf
   else
   	 echo "unity/normalized/$FILENAME-normalized.sdf already exists"
   fi 
   #
 done



for f in $(echo $(ls unity | grep ".sdf3"))
 do
   SDF_FILE=$(echo $f | sed 's/sdf3/sdf/g')
   rm -vf unity/$SDF_FILE
 done

# diff the two files

printf "\n\n\n========================================================================================================================================================\n\n"
printf "Running Tests:"
printf "\n\n*******************************************************\n\n"
for f in $(echo $(ls unity | grep "-normalized.sdf"))
 do
   
   RESULT="$(diff -y unity/$f unity/normalized/$f)" && printf "$f:\nTEST SUCCEEDED\n\n" || printf "$f:\nTEST FAILED:\n\n%s\n\n" "$RESULT"
   printf "\n\n*******************************************************\n\n"

 done





