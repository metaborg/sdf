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

@SuppressWarnings("all") public class $Fence$Defs_1_0 extends Strategy 
{ 
  public static $Fence$Defs_1_0 instance = new $Fence$Defs_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy i_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("FenceDefs_1_0");
    Fail1286:
    { 
      IStrategoTerm a_32968 = null;
      IStrategoTerm z_32967 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consFenceDefs_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1286;
      z_32967 = term.getSubterm(0);
      IStrategoList annos57 = term.getAnnotations();
      a_32968 = annos57;
      term = i_32791.invoke(context, z_32967);
      if(term == null)
        break Fail1286;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consFenceDefs_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, a_32968));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}