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

@SuppressWarnings("all") final class k_9945 extends Strategy 
{ 
  public static final k_9945 instance = new k_9945();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy m_9945)
  { 
    Fail762:
    { 
      lifted226 lifted2260 = new lifted226();
      lifted2260.m_9945 = m_9945;
      term = SRTS_all.instance.invoke(context, term, lifted2260);
      if(term == null)
        break Fail762;
      term = m_9945.invoke(context, term);
      if(term == null)
        break Fail762;
      if(true)
        return term;
    }
    return null;
  }
}