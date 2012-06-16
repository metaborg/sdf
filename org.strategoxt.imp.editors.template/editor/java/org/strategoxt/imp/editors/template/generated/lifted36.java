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

@SuppressWarnings("all") final class lifted36 extends Strategy 
{ 
  public static final lifted36 instance = new lifted36();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail991:
    { 
      IStrategoTerm i_9711 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)term).getConstructor())
        break Fail991;
      i_9711 = term.getSubterm(0);
      term = termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{i_9711});
      if(true)
        return term;
    }
    return null;
  }
}