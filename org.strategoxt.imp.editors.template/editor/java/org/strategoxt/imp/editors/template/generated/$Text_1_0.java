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

@SuppressWarnings("all") public class $Text_1_0 extends Strategy 
{ 
  public static $Text_1_0 instance = new $Text_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_9757)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Text_1_0");
    Fail543:
    { 
      IStrategoTerm t_9940 = null;
      IStrategoTerm s_9940 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consText_1 != ((IStrategoAppl)term).getConstructor())
        break Fail543;
      s_9940 = term.getSubterm(0);
      IStrategoList annos109 = term.getAnnotations();
      t_9940 = annos109;
      term = e_9757.invoke(context, s_9940);
      if(term == null)
        break Fail543;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consText_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, t_9940));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}