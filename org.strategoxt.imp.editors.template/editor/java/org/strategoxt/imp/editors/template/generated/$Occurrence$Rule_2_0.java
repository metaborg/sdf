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

@SuppressWarnings("all") public class $Occurrence$Rule_2_0 extends Strategy 
{ 
  public static $Occurrence$Rule_2_0 instance = new $Occurrence$Rule_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy q_32793, Strategy r_32793)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("OccurrenceRule_2_0");
    Fail1323:
    { 
      IStrategoTerm c_32974 = null;
      IStrategoTerm a_32974 = null;
      IStrategoTerm b_32974 = null;
      IStrategoTerm d_32974 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consOccurrenceRule_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1323;
      a_32974 = term.getSubterm(0);
      b_32974 = term.getSubterm(1);
      IStrategoList annos94 = term.getAnnotations();
      c_32974 = annos94;
      term = q_32793.invoke(context, a_32974);
      if(term == null)
        break Fail1323;
      d_32974 = term;
      term = r_32793.invoke(context, b_32974);
      if(term == null)
        break Fail1323;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consOccurrenceRule_2, new IStrategoTerm[]{d_32974, term}), checkListAnnos(termFactory, c_32974));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}