package org.strategoxt.imp.editors.template.generated;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") final class lifted72 extends Strategy 
{ 
  public static final lifted72 instance = new lifted72();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail929:
    { 
      IStrategoTerm term98 = term;
      Success377:
      { 
        Fail930:
        { 
          if(term.getTermType() != IStrategoTerm.APPL || Main._consterm_1 != ((IStrategoAppl)term).getConstructor())
            break Fail930;
          IStrategoTerm arg108 = term.getSubterm(0);
          if(arg108.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg108).getConstructor())
            break Fail930;
          IStrategoTerm arg109 = arg108.getSubterm(0);
          if(arg109.getTermType() != IStrategoTerm.APPL || Main._consappl_2 != ((IStrategoAppl)arg109).getConstructor())
            break Fail930;
          IStrategoTerm arg110 = arg109.getSubterm(0);
          if(arg110.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg110).getConstructor())
            break Fail930;
          IStrategoTerm arg111 = arg110.getSubterm(0);
          if(arg111.getTermType() != IStrategoTerm.STRING || !"completion".equals(((IStrategoString)arg111).stringValue()))
            break Fail930;
          IStrategoTerm arg112 = arg109.getSubterm(1);
          if(arg112.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg112).isEmpty())
            break Fail930;
          IStrategoTerm arg114 = ((IStrategoList)arg112).tail();
          if(arg114.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg114).isEmpty())
            break Fail930;
          { 
            if(true)
              break Fail929;
            if(true)
              break Success377;
          }
        }
        term = term98;
      }
      if(true)
        return term;
    }
    return null;
  }
}