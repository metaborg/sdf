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

@SuppressWarnings("all") public class $Import$Renamed_2_0 extends Strategy 
{ 
  public static $Import$Renamed_2_0 instance = new $Import$Renamed_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy i_9751, Strategy j_9751)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ImportRenamed_2_0");
    Fail415:
    { 
      IStrategoTerm n_9925 = null;
      IStrategoTerm l_9925 = null;
      IStrategoTerm m_9925 = null;
      IStrategoTerm o_9925 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consImportRenamed_2 != ((IStrategoAppl)term).getConstructor())
        break Fail415;
      l_9925 = term.getSubterm(0);
      m_9925 = term.getSubterm(1);
      IStrategoList annos16 = term.getAnnotations();
      n_9925 = annos16;
      term = i_9751.invoke(context, l_9925);
      if(term == null)
        break Fail415;
      o_9925 = term;
      term = j_9751.invoke(context, m_9925);
      if(term == null)
        break Fail415;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consImportRenamed_2, new IStrategoTerm[]{o_9925, term}), checkListAnnos(termFactory, n_9925));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}