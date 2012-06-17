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

@SuppressWarnings("all") public class $P$P$Table_1_0 extends Strategy 
{ 
  public static $P$P$Table_1_0 instance = new $P$P$Table_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("PPTable_1_0");
    Fail1313:
    { 
      IStrategoTerm z_32971 = null;
      IStrategoTerm y_32971 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consPPTable_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1313;
      y_32971 = term.getSubterm(0);
      IStrategoList annos84 = term.getAnnotations();
      z_32971 = annos84;
      term = u_32792.invoke(context, y_32971);
      if(term == null)
        break Fail1313;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consPPTable_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, z_32971));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}