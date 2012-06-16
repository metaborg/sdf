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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy m_9733)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_origin_track_forced_1_0");
    Fail253:
    { 
      IStrategoTerm p_9733 = null;
      term = (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil0);
      term = SRTS_all.instance.invoke(context, term, m_9733);
      if(term == null)
        break Fail253;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail253;
      p_9733 = ((IStrategoList)term).head();
      IStrategoTerm arg336 = ((IStrategoList)term).tail();
      if(arg336.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg336).isEmpty())
        break Fail253;
      term = p_9733;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}