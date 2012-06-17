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

@SuppressWarnings("all") public class $U$R$L_1_0 extends Strategy 
{ 
  public static $U$R$L_1_0 instance = new $U$R$L_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy o_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("URL_1_0");
    Fail1292:
    { 
      IStrategoTerm s_32968 = null;
      IStrategoTerm r_32968 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consURL_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1292;
      r_32968 = term.getSubterm(0);
      IStrategoList annos63 = term.getAnnotations();
      s_32968 = annos63;
      term = o_32791.invoke(context, r_32968);
      if(term == null)
        break Fail1292;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consURL_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, s_32968));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}