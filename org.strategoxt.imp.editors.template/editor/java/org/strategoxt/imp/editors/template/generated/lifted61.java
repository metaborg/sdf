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

@SuppressWarnings("all") final class lifted61 extends Strategy 
{ 
  TermReference v_9716;

  TermReference w_9716;

  TermReference x_9716;

  TermReference y_9716;

  TermReference z_9716;

  TermReference a_9717;

  TermReference b_9717;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail933:
    { 
      if(y_9716.value == null)
        break Fail933;
      term = map_1_0.instance.invoke(context, y_9716.value, template_production_to_sdf_0_0.instance);
      if(term == null)
        break Fail933;
      if(v_9716.value == null)
        v_9716.value = term;
      else
        if(v_9716.value != term && !v_9716.value.match(term))
          break Fail933;
      if(y_9716.value == null)
        break Fail933;
      term = map_1_0.instance.invoke(context, y_9716.value, templatelang_prod_to_sort_0_0.instance);
      if(term == null)
        break Fail933;
      term = nub_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail933;
      term = map_1_0.instance.invoke(context, term, sort_to_contentcomplete_0_0.instance);
      if(term == null)
        break Fail933;
      if(w_9716.value == null)
        w_9716.value = term;
      else
        if(w_9716.value != term && !w_9716.value.match(term))
          break Fail933;
      IStrategoTerm term90 = term;
      Success378:
      { 
        Fail934:
        { 
          IStrategoTerm c_9717 = null;
          c_9717 = term;
          if(w_9716.value == null)
            break Fail934;
          term = w_9716.value;
          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
            break Fail934;
          term = c_9717;
          { 
            term = generated.constNil0;
            if(x_9716.value == null)
              x_9716.value = term;
            else
              if(x_9716.value != term && !x_9716.value.match(term))
                break Fail933;
            if(true)
              break Success378;
          }
        }
        term = term90;
        if(w_9716.value == null)
          break Fail933;
        term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conscontext_free_syntax_1, new IStrategoTerm[]{w_9716.value}), (IStrategoList)generated.constNil0);
        if(x_9716.value == null)
          x_9716.value = term;
        else
          if(x_9716.value != term && !x_9716.value.match(term))
            break Fail933;
      }
      if(y_9716.value == null)
        break Fail933;
      term = collect_om_1_0.instance.invoke(context, y_9716.value, lifted65.instance);
      if(term == null)
        break Fail933;
      term = filter_1_0.instance.invoke(context, term, lifted66.instance);
      if(term == null)
        break Fail933;
      if(z_9716.value == null)
        z_9716.value = term;
      else
        if(z_9716.value != term && !z_9716.value.match(term))
          break Fail933;
      term = generated.constKeywordFollowRestriction0;
      IStrategoTerm term92 = term;
      Success379:
      { 
        Fail935:
        { 
          term = templatelang_get_option_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail935;
          if(true)
            break Success379;
        }
        term = debug_1_0.instance.invoke(context, term92, lifted67.instance);
        if(term == null)
          break Fail933;
        if(true)
          break Fail933;
      }
      if(a_9717.value == null)
        a_9717.value = term;
      else
        if(a_9717.value != term && !a_9717.value.match(term))
          break Fail933;
      IStrategoTerm term93 = term;
      Success380:
      { 
        Fail936:
        { 
          IStrategoTerm f_9717 = null;
          f_9717 = term;
          IStrategoTerm term94 = term;
          Success381:
          { 
            Fail937:
            { 
              if(z_9716.value == null)
                break Fail937;
              term = z_9716.value;
              if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                break Fail937;
              if(true)
                break Success381;
            }
            term = term94;
            if(a_9717.value == null)
              break Fail936;
            term = a_9717.value;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)term).getConstructor())
              break Fail936;
          }
          term = f_9717;
          { 
            term = generated.constNil0;
            if(b_9717.value == null)
              b_9717.value = term;
            else
              if(b_9717.value != term && !b_9717.value.match(term))
                break Fail933;
            if(true)
              break Success380;
          }
        }
        term = term93;
        if(z_9716.value == null || a_9717.value == null)
          break Fail933;
        term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._conslexical_restrictions_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consfollow_2, new IStrategoTerm[]{z_9716.value, a_9717.value}), (IStrategoList)generated.constNil0)}), (IStrategoList)generated.constNil0);
        if(b_9717.value == null)
          b_9717.value = term;
        else
          if(b_9717.value != term && !b_9717.value.match(term))
            break Fail933;
      }
      if(true)
        return term;
    }
    return null;
  }
}