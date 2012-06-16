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
    Fail397:
    { 
      IStrategoTerm term380 = term;
      Success267:
      { 
        Fail398:
        { 
          IStrategoTerm term381 = term;
          IStrategoConstructor cons37 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
          Success268:
          { 
            if(cons37 == Main._consterm_1)
            { 
              Fail399:
              { 
                IStrategoTerm arg566 = term.getSubterm(0);
                if(arg566.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg566).getConstructor())
                  break Fail399;
                IStrategoTerm arg567 = arg566.getSubterm(0);
                if(arg567.getTermType() != IStrategoTerm.APPL || Main._consappl_2 != ((IStrategoAppl)arg567).getConstructor())
                  break Fail399;
                IStrategoTerm arg568 = arg567.getSubterm(0);
                if(arg568.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg568).getConstructor())
                  break Fail399;
                IStrategoTerm arg569 = arg568.getSubterm(0);
                if(arg569.getTermType() != IStrategoTerm.STRING || !"cons".equals(((IStrategoString)arg569).stringValue()))
                  break Fail399;
                IStrategoTerm arg570 = arg567.getSubterm(1);
                if(arg570.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg570).isEmpty())
                  break Fail399;
                IStrategoTerm arg571 = ((IStrategoList)arg570).head();
                if(arg571.getTermType() != IStrategoTerm.APPL || Main._consfun_1 != ((IStrategoAppl)arg571).getConstructor())
                  break Fail399;
                IStrategoTerm arg572 = arg571.getSubterm(0);
                if(arg572.getTermType() != IStrategoTerm.APPL || Main._consquoted_1 != ((IStrategoAppl)arg572).getConstructor())
                  break Fail399;
                IStrategoTerm arg574 = ((IStrategoList)arg570).tail();
                if(arg574.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg574).isEmpty())
                  break Fail399;
                if(true)
                  break Success268;
              }
              term = term381;
            }
            if(cons37 == Main._consConstructor_1)
            { }
            else
            { 
              break Fail398;
            }
          }
          if(true)
            break Success267;
        }
        term = term380;
        IStrategoTerm y_9750 = null;
        if(term.getTermType() != IStrategoTerm.APPL || Main._consattrs_1 != ((IStrategoAppl)term).getConstructor())
          break Fail397;
        y_9750 = term.getSubterm(0);
        term = getfirst_1_0.instance.invoke(context, y_9750, fetch_cons_0_0.instance);
        if(term == null)
          break Fail397;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}