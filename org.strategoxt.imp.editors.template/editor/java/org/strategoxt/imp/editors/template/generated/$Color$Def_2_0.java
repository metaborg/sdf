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

@SuppressWarnings("all") public class $Color$Def_2_0 extends Strategy 
{ 
  public static $Color$Def_2_0 instance = new $Color$Def_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy j_32790, Strategy k_32790)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ColorDef_2_0");
    Fail1271:
    { 
      IStrategoTerm q_32965 = null;
      IStrategoTerm o_32965 = null;
      IStrategoTerm p_32965 = null;
      IStrategoTerm r_32965 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorDef_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1271;
      o_32965 = term.getSubterm(0);
      p_32965 = term.getSubterm(1);
      IStrategoList annos44 = term.getAnnotations();
      q_32965 = annos44;
      term = j_32790.invoke(context, o_32965);
      if(term == null)
        break Fail1271;
      r_32965 = term;
      term = k_32790.invoke(context, p_32965);
      if(term == null)
        break Fail1271;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorDef_2, new IStrategoTerm[]{r_32965, term}), checkListAnnos(termFactory, q_32965));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}