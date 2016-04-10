# The -orig jar files are the one of the template editor which contain the pretty printer

# jarjar is used to rename the packages in the -orig jars to trans2 instead of trans such that this
# jar files can be loaded together with the editor

# It could be included in the build system but I do not want to touch it here when it is obsolete by now


java -jar jarjar.jar --rules=jarjar.rules templatelang-orig.jar TemplateLang-pp.jar
java -jar jarjar.jar --rules=jarjar.rules templatelang-java-orig.jar templatelang-java.jar