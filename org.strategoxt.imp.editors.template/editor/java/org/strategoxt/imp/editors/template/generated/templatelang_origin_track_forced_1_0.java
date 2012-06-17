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

@SuppressWarnings("all") public class templatelang_origin_track_forced_1_0 extends Strategy 
{ 
  public static templatelang_origin_track_forced_1_0 instance = new templatelang_origin_track_forced_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy v_32771)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_origin_track_forced_1_0");
    Fail1073:
    { 
      IStrategoTerm y_32771 = null;
      term = (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil3);
      term = SRTS_all.instance.invoke(context, term, v_32771);
      if(term == null)
        break Fail1073;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail1073;
      y_32771 = ((IStrategoList)term).head();
      IStrategoTerm arg489 = ((IStrategoList)term).tail();
      if(arg489.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg489).isEmpty())
        break Fail1073;
      term = y_32771;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}