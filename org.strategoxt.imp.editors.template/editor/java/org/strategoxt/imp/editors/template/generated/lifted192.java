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

@SuppressWarnings("all") final class lifted192 extends Strategy 
{ 
  public static final lifted192 instance = new lifted192();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail815:
    { 
      IStrategoTerm n_9946 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)term).getConstructor())
        break Fail815;
      IStrategoTerm arg366 = term.getSubterm(0);
      if(arg366.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg366).isEmpty())
        break Fail815;
      IStrategoTerm arg367 = ((IStrategoList)arg366).head();
      if(arg367.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg367).getConstructor())
        break Fail815;
      n_9946 = arg367.getSubterm(0);
      IStrategoTerm arg368 = ((IStrategoList)arg366).tail();
      if(arg368.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg368).isEmpty())
        break Fail815;
      term = string_length_0_0.instance.invoke(context, n_9946);
      if(term == null)
        break Fail815;
      if(true)
        return term;
    }
    return null;
  }
}