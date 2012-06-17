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

@SuppressWarnings("all") public class $Unmanaged$Table$Prefix_1_0 extends Strategy 
{ 
  public static $Unmanaged$Table$Prefix_1_0 instance = new $Unmanaged$Table$Prefix_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy l_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("UnmanagedTablePrefix_1_0");
    Fail1289:
    { 
      IStrategoTerm j_32968 = null;
      IStrategoTerm i_32968 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consUnmanagedTablePrefix_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1289;
      i_32968 = term.getSubterm(0);
      IStrategoList annos60 = term.getAnnotations();
      j_32968 = annos60;
      term = l_32791.invoke(context, i_32968);
      if(term == null)
        break Fail1289;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consUnmanagedTablePrefix_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, j_32968));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}