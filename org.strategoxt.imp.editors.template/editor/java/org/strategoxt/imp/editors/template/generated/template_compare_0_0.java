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

@SuppressWarnings("all") public class template_compare_0_0 extends Strategy 
{ 
  public static template_compare_0_0 instance = new template_compare_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_compare_0_0");
    Fail1063:
    { 
      IStrategoTerm e_32771 = null;
      IStrategoTerm f_32771 = null;
      IStrategoTerm g_32771 = null;
      IStrategoTerm h_32771 = null;
      IStrategoTerm i_32771 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1063;
      IStrategoTerm arg482 = term.getSubterm(0);
      g_32771 = arg482;
      IStrategoList annos28 = arg482.getAnnotations();
      if(annos28.getTermType() != IStrategoTerm.LIST || ((IStrategoList)annos28).isEmpty())
        break Fail1063;
      e_32771 = ((IStrategoList)annos28).head();
      IStrategoTerm arg483 = ((IStrategoList)annos28).tail();
      if(arg483.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg483).isEmpty())
        break Fail1063;
      IStrategoTerm arg484 = term.getSubterm(1);
      h_32771 = arg484;
      IStrategoList annos29 = arg484.getAnnotations();
      if(annos29.getTermType() != IStrategoTerm.LIST || ((IStrategoList)annos29).isEmpty())
        break Fail1063;
      f_32771 = ((IStrategoList)annos29).head();
      IStrategoTerm arg485 = ((IStrategoList)annos29).tail();
      if(arg485.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg485).isEmpty())
        break Fail1063;
      i_32771 = term;
      Success436:
      { 
        Fail1064:
        { 
          term = termFactory.makeTuple(e_32771, f_32771);
          term = gti_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1064;
          if(true)
            break Success436;
        }
        IStrategoTerm j_32771 = null;
        term = termFactory.makeTuple(e_32771, f_32771);
        term = eq_0_0.instance.invoke(context, term);
        if(term == null)
          break Fail1063;
        term = template_character_count_0_0.instance.invoke(context, g_32771);
        if(term == null)
          break Fail1063;
        j_32771 = term;
        term = template_character_count_0_0.instance.invoke(context, h_32771);
        if(term == null)
          break Fail1063;
        term = termFactory.makeTuple(j_32771, term);
        term = lti_0_0.instance.invoke(context, term);
        if(term == null)
          break Fail1063;
      }
      term = i_32771;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}