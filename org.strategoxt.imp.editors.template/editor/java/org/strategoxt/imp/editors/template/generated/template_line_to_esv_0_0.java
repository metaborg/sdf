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

@SuppressWarnings("all") public class template_line_to_esv_0_0 extends Strategy 
{ 
  public static template_line_to_esv_0_0 instance = new template_line_to_esv_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_line_to_esv_0_0");
    Fail971:
    { 
      IStrategoTerm term413 = term;
      IStrategoConstructor cons23 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success362:
      { 
        if(cons23 == Main._consLine_1)
        { 
          Fail972:
          { 
            IStrategoTerm i_32762 = null;
            IStrategoTerm j_32762 = null;
            IStrategoTerm k_32762 = null;
            IStrategoTerm arg366 = term.getSubterm(0);
            if(arg366.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg366).isEmpty())
              break Fail972;
            IStrategoTerm arg367 = ((IStrategoList)arg366).head();
            if(arg367.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg367).getConstructor())
              break Fail972;
            i_32762 = arg367.getSubterm(0);
            IStrategoTerm arg368 = ((IStrategoList)arg366).tail();
            if(arg368.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg368).isEmpty())
              break Fail972;
            IStrategoTerm arg369 = ((IStrategoList)arg368).head();
            if(arg369.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg369).getConstructor())
              break Fail972;
            k_32762 = arg369.getSubterm(2);
            j_32762 = arg369.getSubterm(3);
            IStrategoTerm arg371 = ((IStrategoList)arg368).tail();
            if(arg371.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg371).isEmpty())
              break Fail972;
            term = k_32762;
            IStrategoTerm term414 = term;
            Success363:
            { 
              Fail973:
              { 
                term = $Option_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail973;
                if(true)
                  break Success363;
              }
              term = $Star_0_0.instance.invoke(context, term414);
              if(term == null)
                break Fail972;
            }
            term = j_32762;
            IStrategoTerm term415 = term;
            Success364:
            { 
              Fail974:
              { 
                term = SRTS_one.instance.invoke(context, term, lifted334.instance);
                if(term == null)
                  break Fail974;
                { 
                  if(true)
                    break Fail972;
                  if(true)
                    break Success364;
                }
              }
              term = term415;
            }
            term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{i_32762}), (IStrategoList)generated.constCons78);
            term = spaces_to_tabs_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail972;
            if(true)
              break Success362;
          }
          term = term413;
        }
        if(cons23 == Main._consLine_1)
        { 
          IStrategoTerm g_32762 = null;
          g_32762 = term.getSubterm(0);
          term = filter_1_0.instance.invoke(context, g_32762, template_element_to_esv_0_0.instance);
          if(term == null)
            break Fail971;
          IStrategoTerm term416 = term;
          Success365:
          { 
            Fail975:
            { 
              if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                break Fail975;
              { 
                if(true)
                  break Fail971;
                if(true)
                  break Success365;
              }
            }
            term = term416;
          }
          term = spaces_to_tabs_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail971;
        }
        else
        { 
          break Fail971;
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