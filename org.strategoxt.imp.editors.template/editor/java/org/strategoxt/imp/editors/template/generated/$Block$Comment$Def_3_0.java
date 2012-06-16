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

@SuppressWarnings("all") public class $Block$Comment$Def_3_0 extends Strategy 
{ 
  public static $Block$Comment$Def_3_0 instance = new $Block$Comment$Def_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_9752, Strategy v_9752, Strategy w_9752)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("BlockCommentDef_3_0");
    Fail463:
    { 
      IStrategoTerm g_9929 = null;
      IStrategoTerm d_9929 = null;
      IStrategoTerm e_9929 = null;
      IStrategoTerm f_9929 = null;
      IStrategoTerm h_9929 = null;
      IStrategoTerm i_9929 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consBlockCommentDef_3 != ((IStrategoAppl)term).getConstructor())
        break Fail463;
      d_9929 = term.getSubterm(0);
      e_9929 = term.getSubterm(1);
      f_9929 = term.getSubterm(2);
      IStrategoList annos36 = term.getAnnotations();
      g_9929 = annos36;
      term = u_9752.invoke(context, d_9929);
      if(term == null)
        break Fail463;
      h_9929 = term;
      term = v_9752.invoke(context, e_9929);
      if(term == null)
        break Fail463;
      i_9929 = term;
      term = w_9752.invoke(context, f_9929);
      if(term == null)
        break Fail463;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consBlockCommentDef_3, new IStrategoTerm[]{h_9929, i_9929, term}), checkListAnnos(termFactory, g_9929));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}