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
    Fail55:
    { 
      IStrategoTerm z_9710 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
        break Fail55;
      IStrategoList annos0 = term.getAnnotations();
      if(annos0.getTermType() != IStrategoTerm.LIST || ((IStrategoList)annos0).isEmpty())
        break Fail55;
      z_9710 = ((IStrategoList)annos0).head();
      IStrategoTerm arg38 = ((IStrategoList)annos0).tail();
      if(arg38.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg38).isEmpty())
        break Fail55;
      term = termFactory.makeAppl(Main._consVar_1, new IStrategoTerm[]{z_9710});
      if(true)
        return term;
    }
    context.push("template_element_to_cons_arg_0_0");
    context.popOnFailure();
    return null;
  }
}