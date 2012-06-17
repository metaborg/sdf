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

@SuppressWarnings("all") public class fetch_cons_0_0 extends Strategy 
{ 
  public static fetch_cons_0_0 instance = new fetch_cons_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("fetch_cons_0_0");
    Fail1217:
    { 
      IStrategoTerm term636 = term;
      Success523:
      { 
        Fail1218:
        { 
          IStrategoTerm term637 = term;
          IStrategoConstructor cons49 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
          Success524:
          { 
            if(cons49 == Main._consterm_1)
            { 
              Fail1219:
              { 
                IStrategoTerm arg719 = term.getSubterm(0);
                if(arg719.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg719).getConstructor())
                  break Fail1219;
                IStrategoTerm arg720 = arg719.getSubterm(0);
                if(arg720.getTermType() != IStrategoTerm.APPL || Main._consappl_2 != ((IStrategoAppl)arg720).getConstructor())
                  break Fail1219;
                IStrategoTerm arg721 = arg720.getSubterm(0);
                if(arg721.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg721).getConstructor())
                  break Fail1219;
                IStrategoTerm arg722 = arg721.getSubterm(0);
                if(arg722.getTermType() != IStrategoTerm.STRING || !"cons".equals(((IStrategoString)arg722).stringValue()))
                  break Fail1219;
                IStrategoTerm arg723 = arg720.getSubterm(1);
                if(arg723.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg723).isEmpty())
                  break Fail1219;
                IStrategoTerm arg724 = ((IStrategoList)arg723).head();
                if(arg724.getTermType() != IStrategoTerm.APPL || Main._consfun_1 != ((IStrategoAppl)arg724).getConstructor())
                  break Fail1219;
                IStrategoTerm arg725 = arg724.getSubterm(0);
                if(arg725.getTermType() != IStrategoTerm.APPL || Main._consquoted_1 != ((IStrategoAppl)arg725).getConstructor())
                  break Fail1219;
                IStrategoTerm arg727 = ((IStrategoList)arg723).tail();
                if(arg727.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg727).isEmpty())
                  break Fail1219;
                if(true)
                  break Success524;
              }
              term = term637;
            }
            if(cons49 == Main._consConstructor_1)
            { }
            else
            { 
              break Fail1218;
            }
          }
          if(true)
            break Success523;
        }
        term = term636;
        IStrategoTerm h_32789 = null;
        if(term.getTermType() != IStrategoTerm.APPL || Main._consattrs_1 != ((IStrategoAppl)term).getConstructor())
          break Fail1217;
        h_32789 = term.getSubterm(0);
        term = getfirst_1_0.instance.invoke(context, h_32789, fetch_cons_0_0.instance);
        if(term == null)
          break Fail1217;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}