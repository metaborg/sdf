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

@SuppressWarnings("all") final class lifted365 extends Strategy 
{ 
  public static final lifted365 instance = new lifted365();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1656:
    { 
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1656;
      IStrategoTerm arg479 = term.getSubterm(1);
      if(arg479.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)arg479).getConstructor())
        break Fail1656;
      term = memo_1_0.instance.invoke(context, term, expand_template_production_0_0.instance);
      if(term == null)
        break Fail1656;
      if(true)
        return term;
    }
    return null;
  }
}