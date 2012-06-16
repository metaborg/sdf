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

@SuppressWarnings("all") public class $Token_1_0 extends Strategy 
{ 
  public static $Token_1_0 instance = new $Token_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy v_9751)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Token_1_0");
    Fail448:
    { 
      IStrategoTerm t_9926 = null;
      IStrategoTerm s_9926 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consToken_1 != ((IStrategoAppl)term).getConstructor())
        break Fail448;
      s_9926 = term.getSubterm(0);
      IStrategoList annos23 = term.getAnnotations();
      t_9926 = annos23;
      term = v_9751.invoke(context, s_9926);
      if(term == null)
        break Fail448;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consToken_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, t_9926));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}