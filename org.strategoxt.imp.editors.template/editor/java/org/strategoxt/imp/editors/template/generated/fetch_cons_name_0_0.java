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

@SuppressWarnings("all") public class fetch_cons_name_0_0 extends Strategy 
{ 
  public static fetch_cons_name_0_0 instance = new fetch_cons_name_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("fetch_cons_name_0_0");
    Fail400:
    { 
      IStrategoTerm term382 = term;
      IStrategoConstructor cons38 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success269:
      { 
        if(cons38 == Main._consterm_1)
        { 
          Fail401:
          { 
            IStrategoTerm b_9751 = null;
            IStrategoTerm arg576 = term.getSubterm(0);
            if(arg576.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg576).getConstructor())
              break Fail401;
            IStrategoTerm arg577 = arg576.getSubterm(0);
            if(arg577.getTermType() != IStrategoTerm.APPL || Main._consappl_2 != ((IStrategoAppl)arg577).getConstructor())
              break Fail401;
            IStrategoTerm arg578 = arg577.getSubterm(0);
            if(arg578.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg578).getConstructor())
              break Fail401;
            IStrategoTerm arg579 = arg578.getSubterm(0);
            if(arg579.getTermType() != IStrategoTerm.STRING || !"cons".equals(((IStrategoString)arg579).stringValue()))
              break Fail401;
            IStrategoTerm arg580 = arg577.getSubterm(1);
            if(arg580.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg580).isEmpty())
              break Fail401;
            IStrategoTerm arg581 = ((IStrategoList)arg580).head();
            if(arg581.getTermType() != IStrategoTerm.APPL || Main._consfun_1 != ((IStrategoAppl)arg581).getConstructor())
              break Fail401;
            IStrategoTerm arg582 = arg581.getSubterm(0);
            if(arg582.getTermType() != IStrategoTerm.APPL || Main._consquoted_1 != ((IStrategoAppl)arg582).getConstructor())
              break Fail401;
            b_9751 = arg582.getSubterm(0);
            IStrategoTerm arg583 = ((IStrategoList)arg580).tail();
            if(arg583.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg583).isEmpty())
              break Fail401;
            term = un_double_quote_0_0.instance.invoke(context, b_9751);
            if(term == null)
              break Fail401;
            if(true)
              break Success269;
          }
          term = term382;
        }
        Success270:
        { 
          if(cons38 == Main._consConstructor_1)
          { 
            Fail402:
            { 
              IStrategoTerm a_9751 = null;
              a_9751 = term.getSubterm(0);
              term = un_double_quote_0_0.instance.invoke(context, a_9751);
              if(term == null)
                break Fail402;
              if(true)
                break Success270;
            }
            term = term382;
          }
          if(cons38 == Main._consattrs_1)
          { 
            IStrategoTerm z_9750 = null;
            z_9750 = term.getSubterm(0);
            term = getfirst_1_0.instance.invoke(context, z_9750, fetch_cons_name_0_0.instance);
            if(term == null)
              break Fail400;
          }
          else
          { 
            break Fail400;
          }
        }
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}