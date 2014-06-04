ChangeLog
=========
These are the main changes in the new SDF3 implementation.

- The following itens are deprecated but still supported:

    - Template sections (<code>templates</code>) should be replaced by context-free syntax sections (`context-free syntax`)
    - Constructor attribute (<code>SortA = SortB {cons("Constructor")</code>) should be replaced by `SortA.Constructor = SortB`
    - Separator option in placeholders (`<A*; separator="\n">`) should be replaced by `<{A "\n"}*>`
    - Reductive form productions `SortB -> SortA {attrs} ` should be replaced by productive form ones `SortA = SortB {attrs}`.    


  - Templates can be specified in context-free section together with regular productions (in the productive form).
  
Example:

    context-free syntax
    
    Statement.Assign = < <ID> = <Exp>; > 
    Exp.Add          = < <Exp> + <Exp> > {left}
    Statement        = Exp
  
  - Kernel Section can be written in productive form.
  - Kernel sorts must be written without angle brackets.

Example:

    syntax

    Statement-CF = ID-CF LAYOUT-CF "=" LAYOUT-CF Exp-CF LAYOUT-CF ";"

  - All these regular expressions are supported in productions:
  
    - Sort? (optional);
    - Sort+ (iter);
    - Sort* (iterStar);
    - {Sort Lit}* (iterStarSep);
    - {Sort Lit}+ (iterSep);
  

  - Alternatives are not supported and should be replaced by productions with additional sorts.
  
Example:

    context-free syntax
    
    LAYOUT = "/*" (~[\*] | CommentChar)* "*/"

should be translated to:

    context-free syntax
    
    LAYOUT  = "/*" SortAlt* "*/"
    SortAlt = ~[\*] 
    SortAlt = CommentChar
    
- All code from SDF3 files is generated in the folders:

 - src-gen/syntax
 - src-gen/signatures
 - src-gen/pp
 - src-gen/completions