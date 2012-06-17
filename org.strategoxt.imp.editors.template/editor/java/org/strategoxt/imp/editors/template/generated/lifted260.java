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

@SuppressWarnings("all") final class lifted260 extends Strategy 
{ 
  TermReference d_32755;

  TermReference e_32755;

  TermReference f_32755;

  TermReference g_32755;

  TermReference h_32755;

  TermReference i_32755;

  TermReference j_32755;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1753:
    { 
      if(g_32755.value == null)
        break Fail1753;
      term = map_1_0.instance.invoke(context, g_32755.value, template_production_to_sdf_0_0.instance);
      if(term == null)
        break Fail1753;
      if(d_32755.value == null)
        d_32755.value = term;
      else
        if(d_32755.value != term && !d_32755.value.match(term))
          break Fail1753;
      if(g_32755.value == null)
        break Fail1753;
      term = map_1_0.instance.invoke(context, g_32755.value, templatelang_prod_to_sort_0_0.instance);
      if(term == null)
        break Fail1753;
      term = nub_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1753;
      term = map_1_0.instance.invoke(context, term, sort_to_contentcomplete_0_0.instance);
      if(term == null)
        break Fail1753;
      if(e_32755.value == null)
        e_32755.value = term;
      else
        if(e_32755.value != term && !e_32755.value.match(term))
          break Fail1753;
      IStrategoTerm term345 = term;
      Success634:
      { 
        Fail1754:
        { 
          IStrategoTerm k_32755 = null;
          k_32755 = term;
          if(e_32755.value == null)
            break Fail1754;
          term = e_32755.value;
          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
            break Fail1754;
          term = k_32755;
          { 
            term = generated.constNil3;
            if(f_32755.value == null)
              f_32755.value = term;
            else
              if(f_32755.value != term && !f_32755.value.match(term))
                break Fail1753;
            if(true)
              break Success634;
          }
        }
        term = term345;
        if(e_32755.value == null)
          break Fail1753;
        term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conscontext_free_syntax_1, new IStrategoTerm[]{e_32755.value}), (IStrategoList)generated.constNil3);
        if(f_32755.value == null)
          f_32755.value = term;
        else
          if(f_32755.value != term && !f_32755.value.match(term))
            break Fail1753;
      }
      if(g_32755.value == null)
        break Fail1753;
      term = collect_om_1_0.instance.invoke(context, g_32755.value, lifted264.instance);
      if(term == null)
        break Fail1753;
      term = filter_1_0.instance.invoke(context, term, lifted265.instance);
      if(term == null)
        break Fail1753;
      if(h_32755.value == null)
        h_32755.value = term;
      else
        if(h_32755.value != term && !h_32755.value.match(term))
          break Fail1753;
      term = generated.constKeywordFollowRestriction0;
      IStrategoTerm term347 = term;
      Success635:
      { 
        Fail1755:
        { 
          term = templatelang_get_option_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1755;
          if(true)
            break Success635;
        }
        term = debug_1_0.instance.invoke(context, term347, lifted266.instance);
        if(term == null)
          break Fail1753;
        if(true)
          break Fail1753;
      }
      if(i_32755.value == null)
        i_32755.value = term;
      else
        if(i_32755.value != term && !i_32755.value.match(term))
          break Fail1753;
      IStrategoTerm term348 = term;
      Success636:
      { 
        Fail1756:
        { 
          IStrategoTerm n_32755 = null;
          n_32755 = term;
          IStrategoTerm term349 = term;
          Success637:
          { 
            Fail1757:
            { 
              if(h_32755.value == null)
                break Fail1757;
              term = h_32755.value;
              if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                break Fail1757;
              if(true)
                break Success637;
            }
            term = term349;
            if(i_32755.value == null)
              break Fail1756;
            term = i_32755.value;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)term).getConstructor())
              break Fail1756;
          }
          term = n_32755;
          { 
            term = generated.constNil3;
            if(j_32755.value == null)
              j_32755.value = term;
            else
              if(j_32755.value != term && !j_32755.value.match(term))
                break Fail1753;
            if(true)
              break Success636;
          }
        }
        term = term348;
        if(h_32755.value == null || i_32755.value == null)
          break Fail1753;
        term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conslexical_restrictions_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consfollow_2, new IStrategoTerm[]{h_32755.value, i_32755.value}), (IStrategoList)generated.constNil3)}), (IStrategoList)generated.constNil3);
        if(j_32755.value == null)
          j_32755.value = term;
        else
          if(j_32755.value != term && !j_32755.value.match(term))
            break Fail1753;
      }
      if(true)
        return term;
    }
    return null;
  }
}