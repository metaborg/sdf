ChangeLog
=========
These are the main changes in the new SDF3 implementation.

#### Deprecated Features


- The following itens are deprecated but still supported:

    - Template sections (<code>templates</code>) should be replaced by context-free syntax sections (`context-free syntax`)
    - Constructor attribute (<code>SortA = SortB {cons("Constructor")</code>) should be replaced by `SortA.Constructor = SortB`
    - Separator option in placeholders (`<A*; separator="\n">`) should be replaced by the correspondent symbol `<{A "\n"}*>`
    - Reductive form productions `SortB -> SortA {attrs} ` should be replaced by productive form ones `SortA = SortB {attrs}`.     
    <br>
  
#### Improvement Features

- Templates can be specified in context-free section together with regular productions (in the productive form).  
  
Example:

    context-free syntax
    
    Statement.Assign = < <ID> = <Exp>; > 
    Exp.Add          = < <Exp> + <Exp> > {left}
    Statement        = Exp
  
  - Productions from Syntax (kernel) and Variables sections can be written in productive form.
  - Kernel sorts must be written without angle brackets.

Example:

    syntax

    Statement-CF = ID-CF LAYOUT-CF "=" LAYOUT-CF Exp-CF LAYOUT-CF ";"
    
- All code from SDF3 files is generated in the folders:

 	- src-gen/syntax
 	- src-gen/signatures
 	- src-gen/pp
 	- src-gen/completions
 	
- Transformation from .sdf and .def files that generate .sdf3 files in the folder src-gen/sdf3-syntax.
 
###### New Builders

There are new builders available for both SDF2 and SDF3 files. They include:

- SDF3 - Generate:
	- Generate .sdf files.
	- Generate pretty printer (a default pretty printer is also generated for non-template productions).
	- Generate content completion .esv files
	- Generate signatures. <br><br>
		
- SDF3 - Format:
	- Format, which generates a prettyprinted .sdf3 file.
	- Lift, which generates a .sdf3 file converting all deprecated items.
	- Lift (templates), which does the same as the previous one, but generates single line templates from regular productions.	<br>
	- Extract productions, which lifts productions to SDF3 and extract regular productions from templates.<br><br>
	
- SDF2 - Generate:
	- Lift to SDF3, which generates .sdf3 files from the sdf2 definition.
	- Lift to SDF3 (templates), which does the same as the previous one, but generates single line templates from regular productions.<br>	 
	
	
	All builders have the option (abstract) to generate .aterm files containing the AST for the respective builder. Builders that generate from SDF2 or format SDF3 files 

#### Dropped Features  


Some sdf2 symbols are not supported whithin .sdf3 files and should be manually replaced by productions with additional sorts:
  
  - Alternatives: 

Example:

    context-free syntax

    Symbol = A | B

should be translated to:

    context-free syntax

    Symbol = Alt
    Alt = A
    Alt = B  
    
 - Sequences:
 

Example:

    context-free syntax
    
    Symbol = (A B C ...)

should be translated to:

    context-free syntax
    
    Symbol = Seq
    Seq.Seq = A B C ...
 
 - Tuples:

Example:

    context-free syntax
    
    Symbol = <A, B, ...>

should be translated to:

    context-free syntax
    
    Symbol = Tuple
    
    Tuple.Tuple = "<" A "," B "," ... ">"
 
 
 - Function:

Example:

    context-free syntax
    
    Symbol = (A => B)

should be translated to:

    context-free syntax
    
    Symbol = Func
    
    Func.Func = "(" A "=>" B ")" 
 
 - Strategy:
 
Example:

    context-free syntax
    
    Symbol = (A -> B)

should be translated to:

    context-free syntax
    
    Symbol = Func
    
    Func.Func = "(" A "->" B ")" 

 	 
 
 Parameterized modules and renamings are also not supported.
