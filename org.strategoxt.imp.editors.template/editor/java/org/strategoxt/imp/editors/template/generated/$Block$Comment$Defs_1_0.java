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

@SuppressWarnings("all") public class $Block$Comment$Defs_1_0 extends Strategy 
{ 
  public static $Block$Comment$Defs_1_0 instance = new $Block$Comment$Defs_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy a_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("BlockCommentDefs_1_0");
    Fail467:
    { 
      IStrategoTerm u_9929 = null;
      IStrategoTerm t_9929 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consBlockCommentDefs_1 != ((IStrategoAppl)term).getConstructor())
        break Fail467;
      t_9929 = term.getSubterm(0);
      IStrategoList annos40 = term.getAnnotations();
      u_9929 = annos40;
      term = a_9753.invoke(context, t_9929);
      if(term == null)
        break Fail467;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consBlockCommentDefs_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, u_9929));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}