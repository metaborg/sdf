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

@SuppressWarnings("all") public class $Fence$Def_2_0 extends Strategy 
{ 
  public static $Fence$Def_2_0 instance = new $Fence$Def_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy b_32791, Strategy c_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("FenceDef_2_0");
    Fail1281:
    { 
      IStrategoTerm j_32967 = null;
      IStrategoTerm h_32967 = null;
      IStrategoTerm i_32967 = null;
      IStrategoTerm k_32967 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consFenceDef_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1281;
      h_32967 = term.getSubterm(0);
      i_32967 = term.getSubterm(1);
      IStrategoList annos53 = term.getAnnotations();
      j_32967 = annos53;
      term = b_32791.invoke(context, h_32967);
      if(term == null)
        break Fail1281;
      k_32967 = term;
      term = c_32791.invoke(context, i_32967);
      if(term == null)
        break Fail1281;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consFenceDef_2, new IStrategoTerm[]{k_32967, term}), checkListAnnos(termFactory, j_32967));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}