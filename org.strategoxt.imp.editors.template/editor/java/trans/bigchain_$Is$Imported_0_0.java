package trans;

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

@SuppressWarnings("all") public class bigchain_$Is$Imported_0_0 extends Strategy 
{ 
  public static bigchain_$Is$Imported_0_0 instance = new bigchain_$Is$Imported_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigchain_IsImported_0_0");
    Fail191:
    { 
      IStrategoTerm z_10734 = null;
      IStrategoTerm c_10735 = null;
      IStrategoTerm e_10735 = null;
      z_10734 = term;
      e_10735 = term;
      Success62:
      { 
        Fail192:
        { 
          IStrategoTerm g_10735 = null;
          g_10735 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, g_10735, trans.const5, z_10734);
          if(term == null)
            break Fail192;
          if(true)
            break Success62;
        }
        term = trans.constNil0;
      }
      c_10735 = term;
      term = e_10735;
      term = termFactory.makeTuple(c_10735, term);
      term = foldl_1_0.instance.invoke(context, term, lifted60.instance);
      if(term == null)
        break Fail191;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}