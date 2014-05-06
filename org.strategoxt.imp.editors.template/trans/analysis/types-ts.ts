module analysis/types-ts

imports 
  include/TemplateLang
  libstrc

type rules
	
	/*Sort(s) : t
		where definition of s: t
		
    Lex(Sort(s)) : t
    	where definition of s: t
    	
    Cf(Sort(s)) : t
    	where definition of s: t
    */
    Iter(s) : t
    	where s : t
    
    IterStar(s) : t
    	where s : t
    
    IterSep(s, Lit(x)) : t
    	where s : t
   
   	IterStarSep(s, Lit(x)) : t
   		where s : t
    
    
    /*type-of:
    Sort(t) -> SortType(t)
    
  type-of(|ctx):
  	Lex(Sort(t)) -> <type-lookup(|ctx)> t
  
  type-of(|ctx):
  	Cf(Sort(t)) -> <type-lookup(|ctx)> t
  
  type-of(|ctx):
    Opt(s) -> <type-lookup(|ctx)> s
  
  type-of(|ctx):
    Iter(s) -> <type-lookup(|ctx)> s
  
  type-of(|ctx):
    IterStar(s) -> <type-lookup(|ctx)> s
  
  type-of(|ctx):
    IterSep(s, Lit(_)) -> ListType(<type-of> s)
  
  type-of(|ctx):
    IterStarSep(s, Lit(_)) -> ListType(<type-of> s)
   */ 	