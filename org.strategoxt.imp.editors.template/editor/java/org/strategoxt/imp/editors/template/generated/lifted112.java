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

@SuppressWarnings("all") final class lifted112 extends Strategy 
{ 
  public static final lifted112 instance = new lifted112();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail871:
    { 
      IStrategoTerm j_9721 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSeparator_1 != ((IStrategoAppl)term).getConstructor())
        break Fail871;
      j_9721 = term.getSubterm(0);
      term = string_as_chars_1_0.instance.invoke(context, j_9721, lifted113.instance);
      if(term == null)
        break Fail871;
      term = templatelang_escape_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail871;
      term = double_quote_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail871;
      if(true)
        return term;
    }
    return null;
  }
}