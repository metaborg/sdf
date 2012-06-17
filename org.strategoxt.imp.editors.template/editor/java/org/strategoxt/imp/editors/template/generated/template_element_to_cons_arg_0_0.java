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

@SuppressWarnings("all") public class template_element_to_cons_arg_0_0 extends Strategy 
{ 
  public static template_element_to_cons_arg_0_0 instance = new template_element_to_cons_arg_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail874:
    { 
      IStrategoTerm h_32749 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
        break Fail874;
      IStrategoList annos18 = term.getAnnotations();
      if(annos18.getTermType() != IStrategoTerm.LIST || ((IStrategoList)annos18).isEmpty())
        break Fail874;
      h_32749 = ((IStrategoList)annos18).head();
      IStrategoTerm arg186 = ((IStrategoList)annos18).tail();
      if(arg186.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg186).isEmpty())
        break Fail874;
      term = termFactory.makeAppl(Main._consVar_1, new IStrategoTerm[]{h_32749});
      if(true)
        return term;
    }
    context.push("template_element_to_cons_arg_0_0");
    context.popOnFailure();
    return null;
  }
}