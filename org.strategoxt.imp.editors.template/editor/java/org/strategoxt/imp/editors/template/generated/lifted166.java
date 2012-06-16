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

@SuppressWarnings("all") final class lifted166 extends Strategy 
{ 
  public static final lifted166 instance = new lifted166();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail836:
    { 
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)term).getConstructor())
        break Fail836;
      IStrategoTerm arg326 = term.getSubterm(1);
      if(arg326.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)arg326).getConstructor())
        break Fail836;
      term = memo_1_0.instance.invoke(context, term, expand_template_production_0_0.instance);
      if(term == null)
        break Fail836;
      if(true)
        return term;
    }
    return null;
  }
}