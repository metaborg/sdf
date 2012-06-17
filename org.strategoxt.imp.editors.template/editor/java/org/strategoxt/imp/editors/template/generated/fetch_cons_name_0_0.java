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
    Fail1220:
    { 
      IStrategoTerm term638 = term;
      IStrategoConstructor cons50 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success525:
      { 
        if(cons50 == Main._consterm_1)
        { 
          Fail1221:
          { 
            IStrategoTerm k_32789 = null;
            IStrategoTerm arg729 = term.getSubterm(0);
            if(arg729.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg729).getConstructor())
              break Fail1221;
            IStrategoTerm arg730 = arg729.getSubterm(0);
            if(arg730.getTermType() != IStrategoTerm.APPL || Main._consappl_2 != ((IStrategoAppl)arg730).getConstructor())
              break Fail1221;
            IStrategoTerm arg731 = arg730.getSubterm(0);
            if(arg731.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg731).getConstructor())
              break Fail1221;
            IStrategoTerm arg732 = arg731.getSubterm(0);
            if(arg732.getTermType() != IStrategoTerm.STRING || !"cons".equals(((IStrategoString)arg732).stringValue()))
              break Fail1221;
            IStrategoTerm arg733 = arg730.getSubterm(1);
            if(arg733.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg733).isEmpty())
              break Fail1221;
            IStrategoTerm arg734 = ((IStrategoList)arg733).head();
            if(arg734.getTermType() != IStrategoTerm.APPL || Main._consfun_1 != ((IStrategoAppl)arg734).getConstructor())
              break Fail1221;
            IStrategoTerm arg735 = arg734.getSubterm(0);
            if(arg735.getTermType() != IStrategoTerm.APPL || Main._consquoted_1 != ((IStrategoAppl)arg735).getConstructor())
              break Fail1221;
            k_32789 = arg735.getSubterm(0);
            IStrategoTerm arg736 = ((IStrategoList)arg733).tail();
            if(arg736.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg736).isEmpty())
              break Fail1221;
            term = un_double_quote_0_0.instance.invoke(context, k_32789);
            if(term == null)
              break Fail1221;
            if(true)
              break Success525;
          }
          term = term638;
        }
        Success526:
        { 
          if(cons50 == Main._consConstructor_1)
          { 
            Fail1222:
            { 
              IStrategoTerm j_32789 = null;
              j_32789 = term.getSubterm(0);
              term = un_double_quote_0_0.instance.invoke(context, j_32789);
              if(term == null)
                break Fail1222;
              if(true)
                break Success526;
            }
            term = term638;
          }
          if(cons50 == Main._consattrs_1)
          { 
            IStrategoTerm i_32789 = null;
            i_32789 = term.getSubterm(0);
            term = getfirst_1_0.instance.invoke(context, i_32789, fetch_cons_name_0_0.instance);
            if(term == null)
              break Fail1220;
          }
          else
          { 
            break Fail1220;
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