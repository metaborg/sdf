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

@SuppressWarnings("all") final class lifted196 extends Strategy 
{ 
  TermReference o_9946;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail811:
    { 
      TermReference v_9946 = new TermReference();
      IStrategoTerm w_9946 = null;
      w_9946 = term;
      if(o_9946.value == null)
        break Fail811;
      term = o_9946.value;
      if(v_9946.value == null)
        v_9946.value = term;
      else
        if(v_9946.value != term && !v_9946.value.match(term))
          break Fail811;
      term = w_9946;
      IStrategoTerm term254 = term;
      Success353:
      { 
        Fail812:
        { 
          if(term.getTermType() != IStrategoTerm.STRING || !"".equals(((IStrategoString)term).stringValue()))
            break Fail812;
          if(true)
            break Success353;
        }
        term = term254;
        lifted197 lifted1970 = new lifted197();
        lifted1970.v_9946 = v_9946;
        term = templatelang_origin_track_forced_1_0.instance.invoke(context, term, lifted1970);
        if(term == null)
          break Fail811;
      }
      if(true)
        return term;
    }
    return null;
  }
}