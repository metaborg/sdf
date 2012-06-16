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

@SuppressWarnings("all") public class $Language$Name_1_0 extends Strategy 
{ 
  public static $Language$Name_1_0 instance = new $Language$Name_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy m_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("LanguageName_1_0");
    Fail479:
    { 
      IStrategoTerm e_9931 = null;
      IStrategoTerm d_9931 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLanguageName_1 != ((IStrategoAppl)term).getConstructor())
        break Fail479;
      d_9931 = term.getSubterm(0);
      IStrategoList annos52 = term.getAnnotations();
      e_9931 = annos52;
      term = m_9753.invoke(context, d_9931);
      if(term == null)
        break Fail479;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consLanguageName_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, e_9931));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}